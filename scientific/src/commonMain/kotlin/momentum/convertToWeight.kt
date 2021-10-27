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

package com.splendo.kaluga.scientific.momentum

import com.splendo.kaluga.scientific.ImperialMomentum
import com.splendo.kaluga.scientific.ImperialSpeed
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricMomentum
import com.splendo.kaluga.scientific.MetricSpeed
import com.splendo.kaluga.scientific.Momentum
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Speed
import com.splendo.kaluga.scientific.UKImperialMomentum
import com.splendo.kaluga.scientific.USCustomaryMomentum
import com.splendo.kaluga.scientific.weight.mass
import kotlin.jvm.JvmName

@JvmName("metricMomentumDivMetricSpeed")
operator fun ScientificValue<MeasurementType.Momentum, MetricMomentum>.div(speed: ScientificValue<MeasurementType.Speed, MetricSpeed>) = unit.mass.mass(this, speed)
@JvmName("imperialMomentumDivImperialSpeed")
operator fun ScientificValue<MeasurementType.Momentum, ImperialMomentum>.div(speed: ScientificValue<MeasurementType.Speed, ImperialSpeed>) = unit.mass.mass(this, speed)
@JvmName("ukImperialMomentumDivImperialSpeed")
operator fun ScientificValue<MeasurementType.Momentum, UKImperialMomentum>.div(speed: ScientificValue<MeasurementType.Speed, ImperialSpeed>) = unit.mass.mass(this, speed)
@JvmName("usCustomaryMomentumDivImperialSpeed")
operator fun ScientificValue<MeasurementType.Momentum, USCustomaryMomentum>.div(speed: ScientificValue<MeasurementType.Speed, ImperialSpeed>) = unit.mass.mass(this, speed)
@JvmName("momentumDivSpeed")
operator fun <MomentumUnit : Momentum, SpeedUnit : Speed> ScientificValue<MeasurementType.Momentum, MomentumUnit>.div(speed: ScientificValue<MeasurementType.Speed, SpeedUnit>) = unit.mass.mass(this, speed)
