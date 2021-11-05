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

package com.splendo.kaluga.scientific.converter.luminance

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.Illuminance
import com.splendo.kaluga.scientific.unit.Luminance
import com.splendo.kaluga.scientific.unit.SolidAngle
import kotlin.jvm.JvmName

@JvmName("luminanceFromIlluminanceAndSolidAngleDefault")
fun <
    LuminanceUnit : Luminance,
    SolidAngleUnit : SolidAngle,
    IlluminanceUnit : Illuminance
    > LuminanceUnit.luminance(
    illuminance: ScientificValue<MeasurementType.Illuminance, IlluminanceUnit>,
    solidAngle: ScientificValue<MeasurementType.SolidAngle, SolidAngleUnit>
) = luminance(illuminance, solidAngle, ::DefaultScientificValue)

@JvmName("luminanceFromIlluminanceAndSolidAngle")
fun <
    LuminanceUnit : Luminance,
    SolidAngleUnit : SolidAngle,
    IlluminanceUnit : Illuminance,
    Value : ScientificValue<MeasurementType.Luminance, LuminanceUnit>
    > LuminanceUnit.luminance(
    illuminance: ScientificValue<MeasurementType.Illuminance, IlluminanceUnit>,
    solidAngle: ScientificValue<MeasurementType.SolidAngle, SolidAngleUnit>,
    factory: (Decimal, LuminanceUnit) -> Value
) = byDividing(illuminance, solidAngle, factory)
