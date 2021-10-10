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
import com.splendo.kaluga.base.utils.div
import com.splendo.kaluga.base.utils.times
import com.splendo.kaluga.base.utils.toDecimal
import kotlinx.serialization.Serializable

@Serializable
sealed class Acceleration<System : MeasurementSystem, LengthUnit : Length<System>, SpeedUnit : Speed<System, LengthUnit>> : AbstractScientificUnit<System, MeasurementType.Acceleration>() {
    abstract val speed: SpeedUnit
    abstract val per: Time
    override val symbol: String by lazy { if (speed.per == per) {
        "${speed.distance.symbol} / ${per.symbol}2"
    } else {
        "${speed.distance.symbol} / (${speed.per.symbol} * ${per.symbol})"
    }
    }
    override fun fromSIUnit(value: Decimal): Decimal = speed.fromSIUnit(value) * per.convert(1.0.toDecimal(), Second)
    override fun toSIUnit(value: Decimal): Decimal = speed.toSIUnit(value) / per.convert(1.0.toDecimal(), Second)
}

@Serializable
data class MetricAcceleration(override val speed: MetricSpeed, override val per: Time) : Acceleration<MeasurementSystem.Metric, MetricLength, MetricSpeed>()

@Serializable
data class ImperialAcceleration(override val speed: ImperialSpeed, override val per: Time) : Acceleration<MeasurementSystem.Imperial, ImperialLength, ImperialSpeed>()

infix fun MetricSpeed.per(time: Time) = MetricAcceleration(this, time)
infix fun ImperialSpeed.per(time: Time) = ImperialAcceleration(this, time)
infix fun Speed<*, *>.per(time: Time) = when (this) {
    is MetricSpeed -> this per time
    is ImperialSpeed -> this per time
}

val MetricStandardGravityAcceleration = ScientificValue(9.80665, Meter per Second per Second)
val ImperialStandardGravityAcceleration = MetricStandardGravityAcceleration.convert(Foot per Second per Second)

inline operator fun <
    System : MeasurementSystem,
    LengthUnit : Length<System>,
    SpeedUnit : Speed<System, LengthUnit>,
    reified AccelerationUnit : Acceleration<System, LengthUnit, SpeedUnit>,
    > ScientificValue<
    System,
    MeasurementType.Speed,
    SpeedUnit,
    >.div(time: ScientificValue<MeasurementSystem.Global, MeasurementType.Time, Time>): ScientificValue<System, MeasurementType.Acceleration, AccelerationUnit> {
    val accelerationUnit = (unit per time.unit) as AccelerationUnit
    return ScientificValue(value / time.value, accelerationUnit)
}
