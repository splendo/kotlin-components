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

package com.splendo.kaluga.scientific.volumetricFlow

import com.splendo.kaluga.scientific.ImperialVolumetricFlow
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricVolumetricFlow
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.UKImperialVolumetricFlow
import com.splendo.kaluga.scientific.USCustomaryVolumetricFlow
import com.splendo.kaluga.scientific.VolumetricFlow
import com.splendo.kaluga.scientific.volume.volume
import kotlin.jvm.JvmName

@JvmName("metricVolumetricFlowTimesTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.VolumetricFlow, MetricVolumetricFlow>.times(time: ScientificValue<MeasurementType.Time, TimeUnit>) = unit.volume.volume(this, time)
@JvmName("imperialVolumetricFlowTimesTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.VolumetricFlow, ImperialVolumetricFlow>.times(time: ScientificValue<MeasurementType.Time, TimeUnit>) = unit.volume.volume(this, time)
@JvmName("ukImperialVolumetricFlowTimesTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.VolumetricFlow, UKImperialVolumetricFlow>.times(time: ScientificValue<MeasurementType.Time, TimeUnit>) = unit.volume.volume(this, time)
@JvmName("usCustomaryVolumetricFlowTimesTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.VolumetricFlow, USCustomaryVolumetricFlow>.times(time: ScientificValue<MeasurementType.Time, TimeUnit>) = unit.volume.volume(this, time)
@JvmName("volumetricFlowTimesTime")
infix operator fun <VolumetricFlowUnit : VolumetricFlow, TimeUnit : Time> ScientificValue<MeasurementType.VolumetricFlow, VolumetricFlowUnit>.times(time: ScientificValue<MeasurementType.Time, TimeUnit>) = unit.volume.volume(this, time)
