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

package com.splendo.kaluga.scientific.decimal

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.BeatsPerMinute
import com.splendo.kaluga.scientific.Frequency
import com.splendo.kaluga.scientific.Hour
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.Radioactivity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Second
import com.splendo.kaluga.scientific.time
import com.splendo.kaluga.scientific.time.time
import kotlin.jvm.JvmName

@JvmName("decimalDivBPM")
operator fun Decimal.div(frequency: ScientificValue<MeasurementType.Frequency, BeatsPerMinute>): ScientificValue<MeasurementType.Time, Hour> = Hour.time(this, frequency)
@JvmName("decimalDivFrequency")
operator fun <FrequencyUnit : Frequency> Decimal.div(frequency: ScientificValue<MeasurementType.Frequency, FrequencyUnit>): ScientificValue<MeasurementType.Time, Second> = Second.time(this, frequency)

@JvmName("decimalDivRadioactivity")
operator fun <RadioactivityUnit : Radioactivity> Decimal.div(radioactivity: ScientificValue<MeasurementType.Radioactivity, RadioactivityUnit>): ScientificValue<MeasurementType.Time, Second> = Second.time(this, radioactivity)
