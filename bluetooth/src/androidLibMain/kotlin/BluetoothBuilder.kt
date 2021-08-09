package com.splendo.kaluga.bluetooth

import android.content.Context
import com.splendo.kaluga.base.ApplicationHolder
import com.splendo.kaluga.bluetooth.device.ConnectionSettings
import com.splendo.kaluga.bluetooth.scanner.Scanner
import com.splendo.kaluga.permissions.PermissionContext
import com.splendo.kaluga.permissions.Permissions
import com.splendo.kaluga.permissions.PermissionsBuilder
import com.splendo.kaluga.permissions.bluetooth.registerBluetoothPermission
import kotlinx.coroutines.CoroutineScope

actual class BluetoothBuilder(
    private val applicationContext: Context = ApplicationHolder.applicationContext,
    private val permissions: Permissions = Permissions(
        PermissionsBuilder(PermissionContext(applicationContext)).apply {
            registerBluetoothPermission()
        }
    ),
    private val scannerBuilder: Scanner.Builder = Scanner.Builder(applicationContext = applicationContext)
) : Bluetooth.Builder {

    override fun create(connectionSettings: ConnectionSettings, autoRequestPermission: Boolean, autoEnableBluetooth: Boolean, coroutineScope: CoroutineScope): Bluetooth {
        return Bluetooth(permissions, connectionSettings, autoRequestPermission, autoEnableBluetooth, scannerBuilder, coroutineScope)
    }
}
