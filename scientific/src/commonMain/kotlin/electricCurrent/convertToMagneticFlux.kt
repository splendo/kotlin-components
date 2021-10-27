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
import com.splendo.kaluga.scientific.Abhenry
import com.splendo.kaluga.scientific.Biot
import com.splendo.kaluga.scientific.ElectricCurrent
import com.splendo.kaluga.scientific.ElectricInductance
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.electricInductance.times
import kotlin.jvm.JvmName

@JvmName("abampereTimesAbhenry")
infix operator fun ScientificValue<MeasurementType.ElectricCurrent, Abampere>.times(inductance: ScientificValue<MeasurementType.ElectricInductance, Abhenry>) = inductance * this
@JvmName("biotTimesAbhenry")
infix operator fun ScientificValue<MeasurementType.ElectricCurrent, Biot>.times(inductance: ScientificValue<MeasurementType.ElectricInductance, Abhenry>) = inductance * this
@JvmName("currentTimesInductance")
infix operator fun <InductanceUnit : ElectricInductance, CurrentUnit : ElectricCurrent> ScientificValue<MeasurementType.ElectricCurrent, CurrentUnit>.times(inductance: ScientificValue<MeasurementType.ElectricInductance, InductanceUnit>) = inductance * this
