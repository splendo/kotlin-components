/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.scientific.converter.volumetricFlux

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.volumetricFlow.volumetricFlow
import com.splendo.kaluga.scientific.unit.Area
import com.splendo.kaluga.scientific.unit.CubicMeter
import com.splendo.kaluga.scientific.unit.ImperialArea
import com.splendo.kaluga.scientific.unit.ImperialVolumetricFlux
import com.splendo.kaluga.scientific.unit.MetricArea
import com.splendo.kaluga.scientific.unit.MetricVolumetricFlux
import com.splendo.kaluga.scientific.unit.Second
import com.splendo.kaluga.scientific.unit.UKImperialVolumetricFlux
import com.splendo.kaluga.scientific.unit.USCustomaryVolumetricFlux
import com.splendo.kaluga.scientific.unit.VolumetricFlux
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

@JvmName("metricVolumetricFluxTimesMetricArea")
infix operator fun <AreaUnit : MetricArea> ScientificValue<PhysicalQuantity.VolumetricFlux, MetricVolumetricFlux>.times(area: ScientificValue<PhysicalQuantity.Area, AreaUnit>) =
    (unit.volumetricFlow).volumetricFlow(this, area)

@JvmName("imperialVolumetricFluxTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<PhysicalQuantity.VolumetricFlux, ImperialVolumetricFlux>.times(
    area: ScientificValue<PhysicalQuantity.Area, AreaUnit>,
) = (unit.volumetricFlow).volumetricFlow(this, area)

@JvmName("ukImperialVolumetricFluxTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<PhysicalQuantity.VolumetricFlux, UKImperialVolumetricFlux>.times(
    area: ScientificValue<PhysicalQuantity.Area, AreaUnit>,
) = (unit.volumetricFlow).volumetricFlow(this, area)

@JvmName("usCustomaryVolumetricFluxTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<PhysicalQuantity.VolumetricFlux, USCustomaryVolumetricFlux>.times(
    area: ScientificValue<PhysicalQuantity.Area, AreaUnit>,
) = (unit.volumetricFlow).volumetricFlow(this, area)

@JvmName("volumetricFluxTimesArea")
infix operator fun <VolumetricFluxUnit : VolumetricFlux, AreaUnit : Area> ScientificValue<PhysicalQuantity.VolumetricFlux, VolumetricFluxUnit>.times(
    area: ScientificValue<PhysicalQuantity.Area, AreaUnit>,
) = (CubicMeter per Second).volumetricFlow(this, area)
