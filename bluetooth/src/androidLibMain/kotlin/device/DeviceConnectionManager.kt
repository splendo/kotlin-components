package com.splendo.kaluga.bluetooth.device

import android.bluetooth.*
import android.content.Context
import android.os.Build
import com.splendo.kaluga.bluetooth.Characteristic
import com.splendo.kaluga.bluetooth.Service
import com.splendo.kaluga.state.StateRepoAccesor
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


internal actual class DeviceConnectionManager(val context: Context, reconnectionAttempts: Int, deviceInfoHolder: DeviceInfoHolder, repoAccessor: StateRepoAccesor<DeviceState>) : BaseDeviceConnectionManager(reconnectionAttempts, deviceInfoHolder, repoAccessor), CoroutineScope by repoAccessor  {

    class Builder(val context: Context) : BaseDeviceConnectionManager.Builder {
        override fun create(reconnectionAttempts: Int, deviceInfo: DeviceInfoHolder, repoAccessor: StateRepoAccesor<DeviceState>): DeviceConnectionManager {
            return DeviceConnectionManager(context, reconnectionAttempts, deviceInfo, repoAccessor)
        }
    }

    val device = deviceInfoHolder.device
    private var gatt: CompletableDeferred<BluetoothGatt> = CompletableDeferred()
    private val callback = object : BluetoothGattCallback() {

        override fun onReadRemoteRssi(gatt: BluetoothGatt?, rssi: Int, status: Int) {
            launch {
                repoAccessor.currentState().rssiDidUpdate(rssi)
            }
        }

        override fun onCharacteristicRead(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int) {
            characteristic ?: return

            launch {
                updateCharacteristic(characteristic)
            }
        }

        override fun onCharacteristicWrite(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int) {
            characteristic ?: return

            launch {
                updateCharacteristic(characteristic)
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
            launch {
                when(val state = repoAccessor.currentState()) {
                    is DeviceState.Connected.Discovering -> state.didDiscoverServices(gatt?.services?.map { Service(it, repoAccessor) } ?: emptyList())
                }
            }
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt?, descriptor: BluetoothGattDescriptor?, status: Int) {
            launch {
                descriptor?.let {
                    updateDescriptor(it)
                }
            }
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?) {
            characteristic ?: return
            launch {
                updateNotifyingCharacteristic(characteristic)
            }
        }

        override fun onDescriptorRead(gatt: BluetoothGatt?, descriptor: BluetoothGattDescriptor?, status: Int) {
            descriptor ?: return
            launch {
                updateDescriptor(descriptor)
            }
        }

        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            launch {
                when (newState) {
                    BluetoothProfile.STATE_DISCONNECTED -> {
                        when (val state = repoAccessor.currentState()) {
                            is DeviceState.Reconnecting -> {
                                if (state.attempt < reconnectionAttempts) {
                                    state.retry()
                                    return@launch
                                }
                            }
                            is DeviceState.Connected -> {
                                if (reconnectionAttempts > 0) {
                                    state.reconnect()
                                    return@launch
                                }
                            }
                        }
                        currentAction = null
                        gatt?.close()
                        this@DeviceConnectionManager.gatt = CompletableDeferred()
                        repoAccessor.currentState().didDisconnect()
                    }
                    BluetoothProfile.STATE_CONNECTED -> {
                        when (val state = repoAccessor.currentState()) {
                            is DeviceState.Connecting -> state.didConnect()
                            is DeviceState.Reconnecting -> state.didConnect()
                            is DeviceState.Connected -> {}
                            else -> gatt?.disconnect()
                        }
                    }
                }
            }
        }
    }

    private var currentAction: DeviceAction? = null
    private val notifyingCharacteristics = emptyMap<String, Characteristic>().toMutableMap()

    override suspend fun connect() {
        unpair()
        if (gatt.isCompleted) {
            gatt.getCompleted().connect()
        } else {
            gatt.complete(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                device.connectGatt(context, false, callback, BluetoothDevice.TRANSPORT_LE)
            } else {
                device.connectGatt(context, false, callback)
            })
        }
    }

    override suspend fun discoverServices() {
        gatt.await().discoverServices()
    }

    override suspend fun disconnect() {
        gatt.await().disconnect()
    }

    override suspend fun readRssi() {
        gatt.await().readRemoteRssi()
    }

    override suspend fun performAction(action: DeviceAction): Boolean {
        currentAction = action
        return when(action) {
            is DeviceAction.Read.Characteristic -> gatt.await().readCharacteristic(action.characteristic.characteristic)
            is DeviceAction.Read.Descriptor -> gatt.await().readDescriptor(action.descriptor.descriptor)
            is DeviceAction.Write.Characteristic -> {
                action.characteristic.characteristic.value = action.newValue
                gatt.await().writeCharacteristic(action.characteristic.characteristic)
            }
            is DeviceAction.Write.Descriptor -> {
                action.descriptor.descriptor.value = action.newValue
                gatt.await().writeDescriptor(action.descriptor.descriptor)
            }
            is DeviceAction.Notification -> {
                val uuid = action.characteristic.uuid.uuidString
                if (action.enable) {
                    notifyingCharacteristics[uuid] = action.characteristic
                } else notifyingCharacteristics.remove(uuid)
                val result = gatt.await().setCharacteristicNotification(action.characteristic.characteristic, action.enable)
                // Action always completes. Launch in separate coroutine to make sure this action can be completed
                launch {
                    completeCurrentAction()
                }
                result
            }
        } ?: false
    }

    private suspend fun updateCharacteristic(characteristic: BluetoothGattCharacteristic) {
        val characteristicToUpdate = when (val action = currentAction) {
            is DeviceAction.Read.Characteristic -> {
                if (action.characteristic.uuid.uuidString == characteristic.uuid.toString()) {
                    action.characteristic
                } else null
            }
            is DeviceAction.Write.Characteristic -> {
                if (action.characteristic.uuid.uuidString == characteristic.uuid.toString()) {
                    action.characteristic
                } else null
            }
            else -> null
        }

        characteristicToUpdate?.let {
            it.characteristic.value = characteristic.value
            it.updateValue()
            completeCurrentAction()
        }
    }

    private suspend fun updateNotifyingCharacteristic(characteristic: BluetoothGattCharacteristic) {
        notifyingCharacteristics[characteristic.uuid.toString()]?.updateValue()
    }

    private suspend fun updateDescriptor(descriptor: BluetoothGattDescriptor) {
        val descriptorToUpdate = when (val action = currentAction) {
            is DeviceAction.Read.Descriptor -> {
                if (action.descriptor.uuid.uuidString == descriptor.uuid.toString()) {
                    action.descriptor
                } else null
            }
            is DeviceAction.Write.Descriptor -> {
                if (action.descriptor.uuid.uuidString == descriptor.uuid.toString()) {
                    action.descriptor
                } else null
            }
            else -> null
        }

        descriptorToUpdate?.let {
            it.descriptor.value = descriptor.value
            it.updateValue()
            completeCurrentAction()
        }
    }

    private suspend fun completeCurrentAction() {
        when (val state = repoAccessor.currentState()) {
            is DeviceState.Connected.HandlingAction -> {
                if (state.action == currentAction) {
                    state.actionCompleted()
                }
            }
        }
        currentAction = null
    }

    private fun unpair() {
        // unpair to prevent connection problems
        if (device.bondState != BluetoothDevice.BOND_NONE) {
            try {
                device.javaClass.getMethod("removeBond").invoke(device)
            } catch (localException: Exception) {
            }

        }
    }
}
