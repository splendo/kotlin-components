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

package com.splendo.kaluga.scientific.time

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.base.utils.div
import com.splendo.kaluga.scientific.Becquerel
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.Radioactivity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Second
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.byInverting
import com.splendo.kaluga.scientific.convert
import com.splendo.kaluga.scientific.convertValue
import com.splendo.kaluga.scientific.invoke

fun <
    TimeUnit : Time,
    RadioactivityUnit : Radioactivity
    > TimeUnit.time(radioactivity: ScientificValue<MeasurementType.Radioactivity, RadioactivityUnit>): ScientificValue<MeasurementType.Time, TimeUnit> = byInverting(radioactivity)

fun <
    RadioactivityUnit : Radioactivity,
    TimeUnit : Time
    > TimeUnit.time(decay: Decimal, at: ScientificValue<MeasurementType.Radioactivity, RadioactivityUnit>): ScientificValue<MeasurementType.Time, TimeUnit> = (decay / at.convertValue(
    Becquerel
))(Second).convert(this)
