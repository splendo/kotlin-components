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

package com.splendo.kaluga.scientific.weight

import com.splendo.kaluga.scientific.CubicMeter
import com.splendo.kaluga.scientific.Density
import com.splendo.kaluga.scientific.ImperialDensity
import com.splendo.kaluga.scientific.ImperialWeight
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricDensity
import com.splendo.kaluga.scientific.MetricWeight
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UKImperialDensity
import com.splendo.kaluga.scientific.UKImperialWeight
import com.splendo.kaluga.scientific.USCustomaryDensity
import com.splendo.kaluga.scientific.USCustomaryWeight
import com.splendo.kaluga.scientific.Weight
import com.splendo.kaluga.scientific.volume.volume
import kotlin.jvm.JvmName

@JvmName("metricWeightDivMetricDensity")
infix operator fun <WeightUnit : MetricWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.div(density: ScientificValue<MeasurementType.Density, MetricDensity>) = density.unit.per.volume(this, density)
@JvmName("imperialWeightDivImperialDensity")
infix operator fun <WeightUnit : ImperialWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.div(density: ScientificValue<MeasurementType.Density, ImperialDensity>) = density.unit.per.volume(this, density)
@JvmName("ukImperialWeightDivUKImperialDensity")
infix operator fun <WeightUnit : UKImperialWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.div(density: ScientificValue<MeasurementType.Density, UKImperialDensity>) = density.unit.per.volume(this, density)
@JvmName("usCustomaryWeightDivUSCustomaryDensity")
infix operator fun <WeightUnit : USCustomaryWeight> ScientificValue<MeasurementType.Weight, WeightUnit>.div(density: ScientificValue<MeasurementType.Density, USCustomaryDensity>) = density.unit.per.volume(this, density)
@JvmName("weightDivDensity")
infix operator fun <WeightUnit : Weight, DensityUnit : Density> ScientificValue<MeasurementType.Weight, WeightUnit>.div(density: ScientificValue<MeasurementType.Density, DensityUnit>) = CubicMeter.volume(this, density)
