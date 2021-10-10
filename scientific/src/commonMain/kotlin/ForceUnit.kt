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
import kotlin.jvm.JvmName

@Serializable
sealed class Force<System : MeasurementSystem> :
    AbstractScientificUnit<System, MeasurementType.Force>()

@Serializable
sealed class MetricForce :
    Force<MeasurementSystem.Metric>()

@Serializable
sealed class USImperialForce :
    Force<MeasurementSystem.USCustomary>()

@Serializable
sealed class UKImperialForce :
    Force<MeasurementSystem.UKImperial>()

@Serializable
sealed class ImperialForce :
    Force<MeasurementSystem.Imperial>()

@Serializable
object Newton : MetricForce(), BaseMetricUnit<MeasurementType.Force, MeasurementSystem.Metric> {
    override val symbol: String = "N"
    override fun fromSIUnit(value: Decimal): Decimal = value
    override fun toSIUnit(value: Decimal): Decimal = value
}

@Serializable
object Nanonewton : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Nano(Newton)
@Serializable
object Micronewton : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Micro(Newton)
@Serializable
object Millinewton : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Milli(Newton)
@Serializable
object Kilonewton : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Kilo(Newton)
@Serializable
object Meganewton : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Mega(Newton)
@Serializable
object Giganewton : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Giga(Newton)

@Serializable
object Dyne : MetricForce(), BaseMetricUnit<MeasurementType.Force, MeasurementSystem.Metric> {
    override val symbol: String = "dyn"
    override fun fromSIUnit(value: Decimal): Decimal = value * 100000.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = value / 100000.toDecimal()
}
@Serializable
object Millidyne : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Milli(Dyne)
@Serializable
object Kilodyne : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Kilo(Dyne)
@Serializable
object Megadyne : MetricForce(), ScientificUnit<MeasurementSystem.Metric, MeasurementType.Force> by Mega(Dyne)
@Serializable
object KilogramForce : MetricForce() {
    override val symbol: String = "kgf"
    override fun fromSIUnit(value: Decimal): Decimal = value / MetricStandardGravityAcceleration.value
    override fun toSIUnit(value: Decimal): Decimal = value * MetricStandardGravityAcceleration.value
}
@Serializable
object TonneForce : MetricForce() {
    override val symbol: String = "tf"
    override fun fromSIUnit(value: Decimal): Decimal = Tonne.fromSIUnit(value) / MetricStandardGravityAcceleration.value
    override fun toSIUnit(value: Decimal): Decimal = Tonne.toSIUnit(value) * MetricStandardGravityAcceleration.value
}
@Serializable
object GramForce : MetricForce() {
    override val symbol: String = "gf"
    override fun fromSIUnit(value: Decimal): Decimal = Gram.fromSIUnit(value) / MetricStandardGravityAcceleration.value
    override fun toSIUnit(value: Decimal): Decimal = Gram.toSIUnit(value) * MetricStandardGravityAcceleration.value
}
@Serializable
object MilligramForce : MetricForce() {
    override val symbol: String = "gf"
    override fun fromSIUnit(value: Decimal): Decimal = Milligram.fromSIUnit(value) / MetricStandardGravityAcceleration.value
    override fun toSIUnit(value: Decimal): Decimal = Milligram.toSIUnit(value) * MetricStandardGravityAcceleration.value
}

// Imperial
@Serializable
object Poundal : ImperialForce() {
    override val symbol: String = "pdl"
    override fun fromSIUnit(value: Decimal): Decimal = Pound.fromSIUnit(value) * 1(Meter per Second per Second).convertValue(Foot per Second per Second)
    override fun toSIUnit(value: Decimal): Decimal = Pound.toSIUnit(value) * 1(Foot per Second per Second).convertValue(Meter per Second per Second)
}

fun <
    MassSystem : MeasurementSystem,
    MassUnit : ScientificUnit<MassSystem, MeasurementType.Weight>,
    AccelerationSystem : MeasurementSystem,
    AccelerationUnit : ScientificUnit<AccelerationSystem, MeasurementType.Acceleration>,
    ForceSystem : MeasurementSystem,
    ForceUnit : ScientificUnit<ForceSystem, MeasurementType.Force>
    > ForceUnit.force(
    mass: ScientificValue<MassSystem, MeasurementType.Weight, MassUnit>,
    acceleration: ScientificValue<AccelerationSystem, MeasurementType.Acceleration, AccelerationUnit>
) : ScientificValue<ForceSystem, MeasurementType.Force, ForceUnit> {
    val massValue = mass.convertValue(Kilogram)
    val accelerationValue = acceleration.convertValue(Meter per Second per Second)
    return (massValue * accelerationValue)(Newton).convert(this)
}

fun <
    MassSystem : MeasurementSystem,
    MassUnit : ScientificUnit<MassSystem, MeasurementType.Weight>,
    AccelerationSystem : MeasurementSystem,
    AccelerationUnit : ScientificUnit<AccelerationSystem, MeasurementType.Acceleration>,
    ForceSystem : MeasurementSystem,
    ForceUnit : ScientificUnit<ForceSystem, MeasurementType.Force>
    > MassUnit.mass(
    force: ScientificValue<ForceSystem, MeasurementType.Force, ForceUnit>,
    acceleration: ScientificValue<AccelerationSystem, MeasurementType.Acceleration, AccelerationUnit>
) : ScientificValue<MassSystem, MeasurementType.Weight, MassUnit> {
    val forceInNewton = force.convertValue(Newton)
    val accelerationInMeterPerSecond2 = acceleration.convertValue(Meter per Second per Second)
    return (forceInNewton / accelerationInMeterPerSecond2)(Kilogram).convert(this)
}

fun <
    MassSystem : MeasurementSystem,
    MassUnit : ScientificUnit<MassSystem, MeasurementType.Weight>,
    AccelerationSystem : MeasurementSystem,
    AccelerationUnit : ScientificUnit<AccelerationSystem, MeasurementType.Acceleration>,
    ForceSystem : MeasurementSystem,
    ForceUnit : ScientificUnit<ForceSystem, MeasurementType.Force>
    > AccelerationUnit.acceleration(
    force: ScientificValue<ForceSystem, MeasurementType.Force, ForceUnit>,
    mass: ScientificValue<MassSystem, MeasurementType.Weight, MassUnit>
) : ScientificValue<AccelerationSystem, MeasurementType.Acceleration, AccelerationUnit> {
    val forceInNewton = force.convertValue(Newton)
    val massInKilogram = mass.convertValue(Kilogram)
    return (forceInNewton / massInKilogram)(Meter per Second per Second).convert(this)
}

@JvmName("kilogramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Newton.force(this, acceleration)
@JvmName("hectogramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Hectogram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Newton.force(this, acceleration)
@JvmName("decagramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Decagram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Newton.force(this, acceleration)
@JvmName("gramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Gram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Dyne.force(this, acceleration)
@JvmName("decigramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Decigram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Dyne.force(this, acceleration)
@JvmName("centigramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Centigram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Dyne.force(this, acceleration)
@JvmName("milligramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Milligram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Dyne.force(this, acceleration)
@JvmName("microgramTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Microgram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Dyne.force(this, acceleration)
@JvmName("nanoTimesAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Nanogram>.times(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Dyne.force(this, acceleration)
@JvmName("accelerationTimesKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = Newton.force(mass, this)
@JvmName("accelerationTimesHectogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Hectogram>) = Newton.force(mass, this)
@JvmName("accelerationTimesDecagram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Decagram>) = Newton.force(mass, this)
@JvmName("accelerationTimesGram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Gram>) = Dyne.force(mass, this)
@JvmName("accelerationTimesDecigram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Decigram>) = Dyne.force(mass, this)
@JvmName("accelerationTimesCentigram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Centigram>) = Dyne.force(mass, this)
@JvmName("accelerationTimesMilligram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Milligram>) = Dyne.force(mass, this)
@JvmName("accelerationTimesMicrogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Microgram>) = Dyne.force(mass, this)
@JvmName("accelerationTimesNanogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>.times(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Nanogram>) = Dyne.force(mass, this)

@JvmName("newtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Newton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("nanonewtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Nanonewton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("micronewtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Micronewton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("millinewtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Millinewton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("kilonewtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Kilonewton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("meganewtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Meganewton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("giganewtonDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Giganewton>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Kilogram.mass(this, acceleration)
@JvmName("dyneDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Dyne>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Gram.mass(this, acceleration)
@JvmName("megadyneDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Megadyne>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Gram.mass(this, acceleration)
@JvmName("kilodyneDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Kilodyne>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Gram.mass(this, acceleration)
@JvmName("millidyneDivAcceleration")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Millidyne>.div(acceleration: ScientificValue<MeasurementSystem.Metric, MeasurementType.Acceleration, MetricAcceleration>) = Gram.mass(this, acceleration)

@JvmName("newtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Newton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("nanonewtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Nanonewton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("micronewtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Micronewton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("millinewtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Millinewton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("kilonewtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Kilonewton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("meganewtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Meganewton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("giganewtonDivKilogram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Giganewton>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Kilogram>) = (Meter per Second per Second).acceleration(this, mass)
@JvmName("dyneDivGram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Dyne>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Gram>) = (Centimeter per Second per Second).acceleration(this, mass)
@JvmName("megadyneDivGram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Megadyne>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Gram>) = (Centimeter per Second per Second).acceleration(this, mass)
@JvmName("kilodyneDivGram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Kilodyne>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Gram>) = (Centimeter per Second per Second).acceleration(this, mass)
@JvmName("millidyneDivGram")
operator fun ScientificValue<MeasurementSystem.Metric, MeasurementType.Force, Millidyne>.div(mass: ScientificValue<MeasurementSystem.Metric, MeasurementType.Weight, Gram>) = (Centimeter per Second per Second).acceleration(this, mass)
