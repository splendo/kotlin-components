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
import com.splendo.kaluga.scientific.converter.energy.div
import com.splendo.kaluga.scientific.converter.force.times
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmName

val MetricAndImperialActionUnits: Set<MetricAndImperialAction> = MetricAndImperialEnergyUnits.flatMap { energy ->
    TimeUnits.map { energy x it }
}.toSet()

val MetricActionUnits: Set<MetricAction> = MetricEnergyUnits.flatMap { energy ->
    TimeUnits.map { energy x it }
}.toSet()

val ImperialActionUnits: Set<ImperialAction> = ImperialEnergyUnits.flatMap { energy ->
    TimeUnits.map { energy x it }
}.toSet()

val ActionUnits: Set<Action> = MetricAndImperialActionUnits +
    MetricActionUnits.filter { it.energy !is MetricMetricAndImperialEnergyWrapper }.toSet() +
    ImperialActionUnits.filter { it.energy !is ImperialMetricAndImperialEnergyWrapper }.toSet()

@Serializable
sealed class Action : AbstractScientificUnit<MeasurementType.Action>() {
    abstract val energy: Energy
    abstract val time: Time
    override val type = MeasurementType.Action
    override val symbol: String by lazy { "${energy.symbol}⋅${time.symbol}" }
    override fun fromSIUnit(value: Decimal): Decimal = time.fromSIUnit(energy.fromSIUnit(value))
    override fun toSIUnit(value: Decimal): Decimal = energy.toSIUnit(time.toSIUnit(value))
}

@Serializable
data class MetricAndImperialAction(override val energy: MetricAndImperialEnergy, override val time: Time) : Action(), MetricAndImperialScientificUnit<MeasurementType.Action> {
    override val system = MeasurementSystem.MetricAndImperial
    val metric get() = energy.metric x time
    val imperial get() = energy.imperial x time
}
@Serializable
data class MetricAction(override val energy: MetricEnergy, override val time: Time) : Action(), MetricScientificUnit<MeasurementType.Action> {
    override val system = MeasurementSystem.Metric
}
@Serializable
data class ImperialAction(override val energy: ImperialEnergy, override val time: Time) : Action(), ImperialScientificUnit<MeasurementType.Action> {
    override val system = MeasurementSystem.Imperial
}

infix fun MetricAndImperialEnergy.x(time: Time) = MetricAndImperialAction(this, time)
infix fun MetricEnergy.x(time: Time) = MetricAction(this, time)
infix fun ImperialEnergy.x(time: Time) = ImperialAction(this, time)
