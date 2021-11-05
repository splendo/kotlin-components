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

package com.splendo.kaluga.scientific.converter.angle

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Angle
import com.splendo.kaluga.scientific.unit.AngularVelocity
import com.splendo.kaluga.scientific.unit.Time
import kotlin.jvm.JvmName

@JvmName("angleFromAngularVelocityAndTimeDefault")
fun <
    AngleUnit : Angle,
    TimeUnit : Time,
    > AngleUnit.angle(
    velocity: ScientificValue<MeasurementType.AngularVelocity, AngularVelocity>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>
) = angle(velocity, time, ::DefaultScientificValue)

@JvmName("angleFromAngularVelocityAndTime")
fun <
    AngleUnit : Angle,
    TimeUnit : Time,
    Value : ScientificValue<MeasurementType.Angle, AngleUnit>
    > AngleUnit.angle(
    velocity: ScientificValue<MeasurementType.AngularVelocity, AngularVelocity>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>,
    factory: (Decimal, AngleUnit) -> Value
) = byMultiplying(velocity, time, factory)
