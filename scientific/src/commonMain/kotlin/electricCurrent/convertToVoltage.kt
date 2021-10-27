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

package com.splendo.kaluga.scientific.electricCurrent

import com.splendo.kaluga.scientific.Abampere
import com.splendo.kaluga.scientific.Abohm
import com.splendo.kaluga.scientific.Absiemens
import com.splendo.kaluga.scientific.Abvolt
import com.splendo.kaluga.scientific.Biot
import com.splendo.kaluga.scientific.ElectricConductance
import com.splendo.kaluga.scientific.ElectricCurrent
import com.splendo.kaluga.scientific.ElectricResistance
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Volt
import com.splendo.kaluga.scientific.voltage.voltage
import kotlin.jvm.JvmName

@JvmName("abampereTimesAbohm")
infix operator fun ScientificValue<MeasurementType.ElectricCurrent, Abampere>.times(resistance: ScientificValue<MeasurementType.ElectricResistance, Abohm>) = Abvolt.voltage(this, resistance)
@JvmName("biotTimesAbohm")
infix operator fun ScientificValue<MeasurementType.ElectricCurrent, Biot>.times(resistance: ScientificValue<MeasurementType.ElectricResistance, Abohm>) = Abvolt.voltage(this, resistance)
@JvmName("currentTimesResistance")
infix operator fun <CurrentUnit : ElectricCurrent, ResistanceUnit : ElectricResistance> ScientificValue<MeasurementType.ElectricCurrent, CurrentUnit>.times(resistance: ScientificValue<MeasurementType.ElectricResistance, ResistanceUnit>) = Volt.voltage(this, resistance)

@JvmName("abampereDivAbsiemens")
infix operator fun ScientificValue<MeasurementType.ElectricCurrent, Abampere>.div(conductance: ScientificValue<MeasurementType.ElectricConductance, Absiemens>) = Abvolt.voltage(this, conductance)
@JvmName("biotDivAbsiemens")
infix operator fun ScientificValue<MeasurementType.ElectricCurrent, Biot>.div(conductance: ScientificValue<MeasurementType.ElectricConductance, Absiemens>) = Abvolt.voltage(this, conductance)
@JvmName("currentDivConductance")
infix operator fun <CurrentUnit : ElectricCurrent, ConductanceUnit : ElectricConductance> ScientificValue<MeasurementType.ElectricCurrent, CurrentUnit>.div(conductance: ScientificValue<MeasurementType.ElectricConductance, ConductanceUnit>) = Volt.voltage(this, conductance)
