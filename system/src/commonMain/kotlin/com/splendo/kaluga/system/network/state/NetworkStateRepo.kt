/*
 Copyright 2020 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package com.splendo.kaluga.system.network.state

import co.touchlab.stately.concurrency.AtomicReference
import com.splendo.kaluga.state.ColdStateRepo
import com.splendo.kaluga.system.network.BaseNetworkManager
import com.splendo.kaluga.system.network.Network
import com.splendo.kaluga.system.network.unknownNetworkOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class NetworkStateRepo(
    private val networkManagerBuilder: BaseNetworkManager.Builder,
) : ColdStateRepo<NetworkState>() {

    interface Builder {
        fun create(): NetworkStateRepo
    }

    private var _lastKnownNetwork = AtomicReference<Network>(Network.Unknown.WithoutLastNetwork(Network.Unknown.Reason.NOT_CLEAR))
    internal var lastKnownNetwork: Network
        get() = _lastKnownNetwork.get()
        set(value) { _lastKnownNetwork.set(value) }

    internal var networkManager: BaseNetworkManager? = null
        set(value) {
            field?.let {
                if(value == null) {
                    it.dispose()
                }
            }
            field = value
        }

    override suspend fun deinitialize(state: NetworkState) {
        lastKnownNetwork = state.networkType
        networkManager = null
    }

    override suspend fun initialValue(): NetworkState {
        networkManager = networkManagerBuilder.create(::onNetworkStateChange)

        return when(val network = lastKnownNetwork) {
            is Network.Unknown.WithoutLastNetwork -> NetworkState.Unknown(
                network.unknownNetworkOf(network.reason)
            )
            is Network.Unknown.WithLastNetwork -> NetworkState.Unknown(
                network.unknownNetworkOf(network.reason)
            )
            is Network.Known.Cellular -> NetworkState.Available(Network.Known.Cellular())
            is Network.Known.Wifi -> NetworkState.Available(
                Network.Known.Wifi(network.isExpensive)
            )
            Network.Known.Absent -> NetworkState.Unknown(
                Network.Unknown.WithoutLastNetwork(Network.Unknown.Reason.NOT_CLEAR)
            )
        }
    }

    internal fun onNetworkStateChange(network: Network) {
        launch {
            takeAndChangeState { state: NetworkState ->
                when (state) {
                    is NetworkState.Available -> {
                        when (network) {
                            is Network.Unknown.WithoutLastNetwork -> {
                                { state.unknownWithoutLastNetwork(network.reason) }
                            }
                            is Network.Unknown.WithLastNetwork -> {
                                { state.unknownWithLastNetwork(network.lastKnownNetwork, network.reason) }
                            }
                            is Network.Known.Cellular -> state.availableWithCellular
                            is Network.Known.Wifi -> state.availableWithWifi
                            Network.Known.Absent -> state.unavailable
                        }
                    }
                    is NetworkState.Unavailable -> {
                        when (network) {
                            is Network.Unknown.WithoutLastNetwork -> state.remain()
                            is Network.Unknown.WithLastNetwork -> state.remain()
                            is Network.Known.Cellular -> state.availableWithCellular
                            is Network.Known.Wifi -> state.availableWithWifi
                            Network.Known.Absent -> state.remain()
                        }
                    }
                    is NetworkState.Unknown -> {
                        when (network) {
                            is Network.Unknown.WithoutLastNetwork -> state.remain()
                            is Network.Unknown.WithLastNetwork -> state.remain()
                            is Network.Known.Cellular -> state.availableWithCellular
                            is Network.Known.Wifi -> state.availableWithWifi
                            Network.Known.Absent -> state.unavailable
                        }
                    }
                }
            }
        }
    }
}

fun Flow<NetworkState>.network(): Flow<Network> {
    return this.map { it.networkType }
}
