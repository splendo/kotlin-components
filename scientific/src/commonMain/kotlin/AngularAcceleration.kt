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

package com.splendo.kaluga.scientific

import com.splendo.kaluga.base.utils.Decimal
import kotlinx.serialization.Serializable

val AngularAccelerationUnits: Set<AngularAcceleration> = AngularVelocityUnits.flatMap { angularVelocity ->
    TimeUnits.map { angularVelocity per it }
}.toSet()

@Serializable
data class AngularAcceleration(val angularVelocity: AngularVelocity, val per: Time) : AbstractScientificUnit<MeasurementType.AngularAcceleration>(), MetricAndImperialScientificUnit<MeasurementType.AngularAcceleration> {
    override val type = MeasurementType.AngularAcceleration
    override val system = MeasurementSystem.MetricAndImperial
    override val symbol: String by lazy {
        if (angularVelocity.per == per) {
            "${angularVelocity.angle.symbol} / ${per.symbol}2"
        } else {
            "${angularVelocity.angle.symbol} / (${angularVelocity.per.symbol} * ${per.symbol})"
        }
    }
    override fun fromSIUnit(value: Decimal): Decimal = per.toSIUnit(angularVelocity.fromSIUnit(value))
    override fun toSIUnit(value: Decimal): Decimal = angularVelocity.toSIUnit(per.fromSIUnit(value))
}

infix fun AngularVelocity.per(time: Time) = AngularAcceleration(this, time)
