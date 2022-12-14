/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.bluetooth

import com.splendo.kaluga.bluetooth.device.ConnectionSettings
import com.splendo.kaluga.bluetooth.scanner.BaseScanner
import com.splendo.kaluga.permissions.base.Permissions
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock
import com.splendo.kaluga.test.base.mock.verify
import com.splendo.kaluga.test.bluetooth.scanner.MockBaseScanner
import com.splendo.kaluga.test.permissions.MockPermissionsBuilder
import kotlinx.coroutines.CoroutineName
import kotlin.test.Test

private class FakeBuilder : Bluetooth.Builder() {

    private val scannerBuilder = MockBaseScanner.Builder(true)

    val permissionsBuilder: MockPermissionsBuilder = MockPermissionsBuilder().apply {
        registerAllPermissionsBuilders()
    }

    private val bluetooth = Bluetooth(
        scannerSettingsBuilder = {
            scannerSettingsFactory(
                Permissions(
                    permissionsBuilder,
                    coroutineContext = coroutineContext
                )
            )
        },
        connectionSettings = defaultConnectionSettings,
        scannerBuilder = scannerBuilder,
        coroutineContext = coroutineContext
    )

    val createMock = ::create.mock().apply {
        on().doReturn(bluetooth)
    }
    override fun create(): BluetoothService = createMock.call()
}

class BluetoothServiceBuilderTest {

    @Test
    fun `"buildBluetoothService" it creates bluetooth service`() {
        val bluetoothBuilder = FakeBuilder()

        bluetoothBuilder.buildBluetoothService {
            coroutineContext = CoroutineName("Test")
            defaultConnectionSettings = ConnectionSettings(
                reconnectionSettings = ConnectionSettings.ReconnectionSettings.Never
            )
            scannerSettingsFactory = { permissions: Permissions ->
                BaseScanner.Settings(
                    permissions,
                    autoRequestPermission = true,
                    autoEnableSensors = true
                )
            }
        }

        bluetoothBuilder.createMock.verify(1)
    }
}
