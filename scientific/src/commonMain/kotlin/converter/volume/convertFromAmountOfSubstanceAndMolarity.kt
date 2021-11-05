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

package com.splendo.kaluga.scientific.converter.volume

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AmountOfSubstance
import com.splendo.kaluga.scientific.unit.Molarity
import com.splendo.kaluga.scientific.unit.Volume
import kotlin.jvm.JvmName

@JvmName("volumeFromAmountOfSubstanceAndMolarityDefault")
fun <
    AmountOfSubstanceUnit : AmountOfSubstance,
    VolumeUnit : Volume,
    MolarityUnit : Molarity
    > VolumeUnit.volume(
    amountOfSubstance: ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>,
    molarity: ScientificValue<MeasurementType.Molarity, MolarityUnit>
) = volume(amountOfSubstance, molarity, ::DefaultScientificValue)

@JvmName("volumeFromAmountOfSubstanceAndMolarity")
fun <
    AmountOfSubstanceUnit : AmountOfSubstance,
    VolumeUnit : Volume,
    MolarityUnit : Molarity,
    Value : ScientificValue<MeasurementType.Volume, VolumeUnit>
    > VolumeUnit.volume(
    amountOfSubstance: ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>,
    molarity: ScientificValue<MeasurementType.Molarity, MolarityUnit>,
    factory: (Decimal, VolumeUnit) -> Value
) = byDividing(amountOfSubstance, molarity, factory)
