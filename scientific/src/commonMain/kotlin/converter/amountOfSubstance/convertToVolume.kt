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
import com.splendo.kaluga.scientific.CubicMeter
import com.splendo.kaluga.scientific.ImperialMolarVolume
import com.splendo.kaluga.scientific.ImperialMolarity
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricMolarVolume
import com.splendo.kaluga.scientific.MetricMolarity
import com.splendo.kaluga.scientific.MolarVolume
import com.splendo.kaluga.scientific.Molarity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UKImperialMolarVolume
import com.splendo.kaluga.scientific.UKImperialMolarity
import com.splendo.kaluga.scientific.USCustomaryMolarVolume
import com.splendo.kaluga.scientific.USCustomaryMolarity
import com.splendo.kaluga.scientific.converter.molarVolume.times
import com.splendo.kaluga.scientific.converter.volume.volume
import kotlin.jvm.JvmName

@JvmName("amountOfSubstanceDivMetricMolarity")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.div(molarity: ScientificValue<MeasurementType.Molarity, MetricMolarity>) = molarity.unit.per.volume(this, molarity)
@JvmName("amountOfSubstanceDivImperialMolarity")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.div(molarity: ScientificValue<MeasurementType.Molarity, ImperialMolarity>) = molarity.unit.per.volume(this, molarity)
@JvmName("amountOfSubstanceDivUKImperialMolarity")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.div(molarity: ScientificValue<MeasurementType.Molarity, UKImperialMolarity>) = molarity.unit.per.volume(this, molarity)
@JvmName("amountOfSubstanceDivUSCustomaryMolarity")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.div(molarity: ScientificValue<MeasurementType.Molarity, USCustomaryMolarity>) = molarity.unit.per.volume(this, molarity)
@JvmName("amountOfSubstanceDivMolarity")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance, MolarityUnit : Molarity> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.div(molarity: ScientificValue<MeasurementType.Molarity, MolarityUnit>) = CubicMeter.volume(this, molarity)

@JvmName("amountOfSubstanceTimesMetricMolarVolume")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.times(molarVolume: ScientificValue<MeasurementType.MolarVolume, MetricMolarVolume>) = molarVolume * this
@JvmName("amountOfSubstanceTimesImperialMolarVolume")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.times(molarVolume: ScientificValue<MeasurementType.MolarVolume, ImperialMolarVolume>) = molarVolume * this
@JvmName("amountOfSubstanceTimesUKImperialMolarVolume")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.times(molarVolume: ScientificValue<MeasurementType.MolarVolume, UKImperialMolarVolume>) = molarVolume * this
@JvmName("amountOfSubstanceTimesUSCustomaryMolarVolume")
infix operator fun <AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.times(molarVolume: ScientificValue<MeasurementType.MolarVolume, USCustomaryMolarVolume>) = molarVolume * this
@JvmName("amountOfSubstanceTimesMolarVolume")
infix operator fun <MolarVolumeUnit : MolarVolume, AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<MeasurementType.AmountOfSubstance, AmountOfSubstanceUnit>.times(molarVolume: ScientificValue<MeasurementType.MolarVolume, MolarVolumeUnit>) = molarVolume * this
