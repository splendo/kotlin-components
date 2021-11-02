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

package com.splendo.kaluga.scientific.converter.amountOfSubstance

import com.splendo.kaluga.scientific.AmountOfSubstance
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MolarVolume
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Volume
import com.splendo.kaluga.scientific.byDividing
import kotlin.jvm.JvmName

@JvmName("amountOfSubstanceFromVolumeAndMolarVolume")
fun <
    AmountOfSubstanceUnit : AmountOfSubstance,
    VolumeUnit : Volume,
    MolarVolumeUnit : MolarVolume
    > AmountOfSubstanceUnit.amountOfSubstance(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>,
    molarVolume: ScientificValue<MeasurementType.MolarVolume, MolarVolumeUnit>,
) = byDividing(volume, molarVolume)