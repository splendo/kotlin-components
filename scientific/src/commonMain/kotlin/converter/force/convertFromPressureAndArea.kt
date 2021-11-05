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

package com.splendo.kaluga.scientific.converter.force

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Area
import com.splendo.kaluga.scientific.unit.Force
import com.splendo.kaluga.scientific.unit.Pressure
import kotlin.jvm.JvmName

@JvmName("forceFromPressureAndAreaDefault")
fun <
    ForceUnit : Force,
    AreaUnit : Area,
    PressureUnit : Pressure
    > ForceUnit.force(
    pressure: ScientificValue<MeasurementType.Pressure, PressureUnit>,
    area: ScientificValue<MeasurementType.Area, AreaUnit>
) = force(pressure, area, ::DefaultScientificValue)

@JvmName("forceFromPressureAndArea")
fun <
    ForceUnit : Force,
    AreaUnit : Area,
    PressureUnit : Pressure,
    Value : ScientificValue<MeasurementType.Force, ForceUnit>
    > ForceUnit.force(
    pressure: ScientificValue<MeasurementType.Pressure, PressureUnit>,
    area: ScientificValue<MeasurementType.Area, AreaUnit>,
    factory: (Decimal, ForceUnit) -> Value
) = byMultiplying(pressure, area, factory)
