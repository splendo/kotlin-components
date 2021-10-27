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

package com.splendo.kaluga.scientific.power

import com.splendo.kaluga.scientific.Energy
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.Power
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.byDividing
import kotlin.jvm.JvmName

@JvmName("powerFromEnergyAndTime")
fun <
    EnergyUnit : Energy,
    TimeUnit : Time,
    PowerUnit : Power
    > PowerUnit.power(
    energy: ScientificValue<MeasurementType.Energy, EnergyUnit>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>
): ScientificValue<MeasurementType.Power, PowerUnit> = byDividing(energy, time)
