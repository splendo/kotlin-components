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

package com.splendo.kaluga.scientific.converter.weight

import com.splendo.kaluga.scientific.ImperialWeight
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricSpecificHeatCapacity
import com.splendo.kaluga.scientific.MetricWeight
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.SpecificHeatCapacity
import com.splendo.kaluga.scientific.UKImperialSpecificHeatCapacity
import com.splendo.kaluga.scientific.UKImperialWeight
import com.splendo.kaluga.scientific.USCustomarySpecificHeatCapacity
import com.splendo.kaluga.scientific.USCustomaryWeight
import com.splendo.kaluga.scientific.Weight
import com.splendo.kaluga.scientific.converter.specificHeatCapacity.times
import kotlin.jvm.JvmName

@JvmName("metricWeightTimesMetricSpecificHeatCapacity")
infix operator fun <WeightUnit : MetricWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.times(specificHeatCapacity: ScientificValue<MeasurementType.SpecificHeatCapacity, MetricSpecificHeatCapacity>) = specificHeatCapacity * this
@JvmName("imperialWeightTimesUKImperialSpecificHeatCapacity")
infix operator fun <WeightUnit : ImperialWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.times(specificHeatCapacity: ScientificValue<MeasurementType.SpecificHeatCapacity, UKImperialSpecificHeatCapacity>) = specificHeatCapacity * this
@JvmName("ukImperialWeightUKImperialSpecificHeatCapacity")
infix operator fun <WeightUnit : UKImperialWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.times(specificHeatCapacity: ScientificValue<MeasurementType.SpecificHeatCapacity, UKImperialSpecificHeatCapacity>) = specificHeatCapacity * this
@JvmName("imperialWeightTimesUSCustomarySpecificHeatCapacity")
infix operator fun <WeightUnit : ImperialWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.times(specificHeatCapacity: ScientificValue<MeasurementType.SpecificHeatCapacity, USCustomarySpecificHeatCapacity>) = specificHeatCapacity * this
@JvmName("usCustomaryWeightTimesUSCustomarySpecificHeatCapacity")
infix operator fun <WeightUnit : USCustomaryWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.times(specificHeatCapacity: ScientificValue<MeasurementType.SpecificHeatCapacity, USCustomarySpecificHeatCapacity>) = specificHeatCapacity * this
@JvmName("weightTimesSpecificHeatCapacity")
infix operator fun <SpecificHeatCapacityUnit : SpecificHeatCapacity, WeightUnit : Weight> ScientificValue<MeasurementType.Weight, WeightUnit>.times(specificHeatCapacity: ScientificValue<MeasurementType.SpecificHeatCapacity, SpecificHeatCapacityUnit>) = specificHeatCapacity * this
