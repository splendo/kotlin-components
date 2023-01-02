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

package com.splendo.kaluga.test.bluetooth

import com.splendo.kaluga.bluetooth.ServiceWrapper
import com.splendo.kaluga.bluetooth.device.DeviceWrapper
import com.splendo.kaluga.bluetooth.device.Identifier

expect fun randomIdentifier(): Identifier

expect fun createDeviceWrapper(
    deviceName: String? = null,
    identifier: Identifier = randomIdentifier()
): DeviceWrapper

fun createServiceWrapper(
    builder: ServiceWrapperBuilder.() -> Unit
): ServiceWrapper = ServiceWrapperBuilder().apply(builder).build()

interface CanUpdateMockValue {
    fun updateMockValue(value: ByteArray?)
}
