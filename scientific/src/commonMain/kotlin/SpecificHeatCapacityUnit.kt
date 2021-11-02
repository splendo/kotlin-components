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
import com.splendo.kaluga.base.utils.minus
import com.splendo.kaluga.base.utils.plus
import com.splendo.kaluga.base.utils.toDecimal
import com.splendo.kaluga.scientific.converter.heatCapacity.times
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmName

val MetricSpecificHeatCapacityUnits: Set<MetricSpecificHeatCapacity> = MetricHeatCapacityUnits.flatMap { heatCapacity ->
    MetricWeightUnits.map { heatCapacity per it }
}.toSet()

val UKImperialSpecificHeatCapacityUnits: Set<UKImperialSpecificHeatCapacity> = UKImperialHeatCapacityUnits.flatMap { heatCapacity ->
    UKImperialWeightUnits.map { heatCapacity per it }
}.toSet()

val USCustomarySpecificHeatCapacityUnits: Set<USCustomarySpecificHeatCapacity> = USCustomaryHeatCapacityUnits.flatMap { heatCapacity ->
    USCustomaryWeightUnits.map { heatCapacity per it }
}.toSet()

val SpecificHeatCapacityUnits: Set<SpecificHeatCapacity> = MetricSpecificHeatCapacityUnits +
    UKImperialSpecificHeatCapacityUnits +
    USCustomarySpecificHeatCapacityUnits

@Serializable
sealed class SpecificHeatCapacity : AbstractScientificUnit<MeasurementType.SpecificHeatCapacity>() {
    abstract val energy: Energy
    abstract val perTemperature: Temperature
    abstract val perWeight: Weight
    override val type = MeasurementType.SpecificHeatCapacity
    override val symbol: String by lazy { "${energy.symbol}/(${perTemperature.symbol}⋅${perWeight.symbol})" }
    override fun fromSIUnit(value: Decimal): Decimal = perWeight.toSIUnit(perTemperature.toSIUnit(energy.fromSIUnit(value)) - perTemperature.toSIUnit(0.toDecimal()))
    override fun toSIUnit(value: Decimal): Decimal = energy.toSIUnit(perTemperature.fromSIUnit(perWeight.fromSIUnit(value))) + perTemperature.fromSIUnit(0.toDecimal())
}

@Serializable
data class MetricSpecificHeatCapacity(override val energy: MetricEnergy, override val perTemperature: MetricAndUKImperialTemperature, override val perWeight: MetricWeight) : SpecificHeatCapacity(), MetricScientificUnit<MeasurementType.SpecificHeatCapacity> {
    override val system = MeasurementSystem.Metric
}
@Serializable
data class UKImperialSpecificHeatCapacity(override val energy: ImperialEnergy, override val perTemperature: MetricAndUKImperialTemperature, override val perWeight: UKImperialWeight) : SpecificHeatCapacity(), UKImperialScientificUnit<MeasurementType.SpecificHeatCapacity> {
    override val system = MeasurementSystem.UKImperial
}
@Serializable
data class USCustomarySpecificHeatCapacity(override val energy: ImperialEnergy, override val perTemperature: USCustomaryTemperature, override val perWeight: USCustomaryWeight) : SpecificHeatCapacity(), USCustomaryScientificUnit<MeasurementType.SpecificHeatCapacity> {
    override val system = MeasurementSystem.USCustomary
}

infix fun MetricAndUKImperialHeatCapacity.per(weight: MetricWeight) = MetricSpecificHeatCapacity(energy.metric, per, weight)
infix fun MetricAndUKImperialHeatCapacity.per(weight: ImperialWeight) = UKImperialSpecificHeatCapacity(energy.imperial, per, weight.ukImperial)
infix fun MetricAndUKImperialHeatCapacity.per(weight: UKImperialWeight) = UKImperialSpecificHeatCapacity(energy.imperial, per, weight)
infix fun MetricHeatCapacity.per(weight: MetricWeight) = MetricSpecificHeatCapacity(energy, per, weight)
infix fun UKImperialHeatCapacity.per(weight: ImperialWeight) = UKImperialSpecificHeatCapacity(energy, per, weight.ukImperial)
infix fun UKImperialHeatCapacity.per(weight: UKImperialWeight) = UKImperialSpecificHeatCapacity(energy, per, weight)
infix fun USCustomaryHeatCapacity.per(weight: ImperialWeight) = USCustomarySpecificHeatCapacity(energy, per, weight.usCustomary)
infix fun USCustomaryHeatCapacity.per(weight: USCustomaryWeight) = USCustomarySpecificHeatCapacity(energy, per, weight)

infix fun MetricSpecificEnergy.per(temperature: MetricAndUKImperialTemperature) = MetricSpecificHeatCapacity(energy, temperature, per)
infix fun ImperialSpecificEnergy.per(temperature: MetricAndUKImperialTemperature) = UKImperialSpecificHeatCapacity(energy, temperature, per.ukImperial)
infix fun ImperialSpecificEnergy.per(temperature: USCustomaryTemperature) = USCustomarySpecificHeatCapacity(energy, temperature, per.usCustomary)
infix fun UKImperialSpecificEnergy.per(temperature: MetricAndUKImperialTemperature) = UKImperialSpecificHeatCapacity(energy, temperature, per)
infix fun USCustomarySpecificEnergy.per(temperature: USCustomaryTemperature) = USCustomarySpecificHeatCapacity(energy, temperature, per)
