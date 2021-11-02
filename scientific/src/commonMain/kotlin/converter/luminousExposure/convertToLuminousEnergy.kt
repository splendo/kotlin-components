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

package com.splendo.kaluga.scientific.converter.luminousExposure

import com.splendo.kaluga.scientific.Area
import com.splendo.kaluga.scientific.ImperialArea
import com.splendo.kaluga.scientific.ImperialLuminousExposure
import com.splendo.kaluga.scientific.LuminousExposure
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricArea
import com.splendo.kaluga.scientific.MetricLuminousExposure
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.illuminance.times
import com.splendo.kaluga.scientific.converter.luminousEnergy.luminousEnergy
import com.splendo.kaluga.scientific.invoke
import com.splendo.kaluga.scientific.x
import kotlin.jvm.JvmName

@JvmName("metricExposureTimesMetricArea")
infix operator fun <AreaUnit : MetricArea> ScientificValue<MeasurementType.LuminousExposure, MetricLuminousExposure>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.illuminance) * 1(area.unit)).unit x unit.time).luminousEnergy(this, area)
@JvmName("imperialExposureTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<MeasurementType.LuminousExposure, ImperialLuminousExposure>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.illuminance) * 1(area.unit)).unit x unit.time).luminousEnergy(this, area)
@JvmName("exposureTimesArea")
infix operator fun <ExposureUnit : LuminousExposure, AreaUnit : Area> ScientificValue<MeasurementType.LuminousExposure, ExposureUnit>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.illuminance) * 1(area.unit)).unit x unit.time).luminousEnergy(this, area)
