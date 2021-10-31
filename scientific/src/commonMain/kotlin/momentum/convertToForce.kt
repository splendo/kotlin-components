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
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricMomentum
import com.splendo.kaluga.scientific.Momentum
import com.splendo.kaluga.scientific.Newton
import com.splendo.kaluga.scientific.PoundForce
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.UKImperialMomentum
import com.splendo.kaluga.scientific.USCustomaryMomentum
import com.splendo.kaluga.scientific.force.force
import com.splendo.kaluga.scientific.ukImperial
import com.splendo.kaluga.scientific.usCustomary
import kotlin.jvm.JvmName

@JvmName("metricMomentumDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Momentum, MetricMomentum>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = Newton.force(this, time)
@JvmName("imperialMomentumDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Momentum, ImperialMomentum>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = PoundForce.force(this, time)
@JvmName("ukImperialMomentumDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Momentum, UKImperialMomentum>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = PoundForce.ukImperial.force(this, time)
@JvmName("usCustomaryMomentumDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Momentum, USCustomaryMomentum>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = PoundForce.usCustomary.force(this, time)
@JvmName("momentumDivTime")
infix operator fun <MomentumUnit : Momentum, TimeUnit : Time> ScientificValue<MeasurementType.Momentum, MomentumUnit>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) = Newton.force(this, time)
