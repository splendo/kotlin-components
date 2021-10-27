/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.scientific.magneticFlux

import com.splendo.kaluga.scientific.Abvolt
import com.splendo.kaluga.scientific.MagneticFlux
import com.splendo.kaluga.scientific.Maxwell
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.Volt
import com.splendo.kaluga.scientific.voltage.voltage
import kotlin.jvm.JvmName

@JvmName("maxwellDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.MagneticFlux, Maxwell>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = Abvolt.voltage(this, time)
@JvmName("fluxDivTime")
infix operator fun <FluxUnit : MagneticFlux, TimeUnit : Time> ScientificValue<MeasurementType.MagneticFlux, FluxUnit>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = Volt.voltage(this, time)
