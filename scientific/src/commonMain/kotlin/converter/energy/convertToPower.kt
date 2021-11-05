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

package com.splendo.kaluga.scientific.converter.energy

import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.power.power
import com.splendo.kaluga.scientific.unit.BritishThermalUnit
import com.splendo.kaluga.scientific.unit.BritishThermalUnitPerHour
import com.splendo.kaluga.scientific.unit.BritishThermalUnitPerMinute
import com.splendo.kaluga.scientific.unit.BritishThermalUnitPerSecond
import com.splendo.kaluga.scientific.unit.Centijoule
import com.splendo.kaluga.scientific.unit.Centiwatt
import com.splendo.kaluga.scientific.unit.CentiwattHour
import com.splendo.kaluga.scientific.unit.Decajoule
import com.splendo.kaluga.scientific.unit.Decawatt
import com.splendo.kaluga.scientific.unit.DecawattHour
import com.splendo.kaluga.scientific.unit.Decijoule
import com.splendo.kaluga.scientific.unit.Deciwatt
import com.splendo.kaluga.scientific.unit.DeciwattHour
import com.splendo.kaluga.scientific.unit.Energy
import com.splendo.kaluga.scientific.unit.Erg
import com.splendo.kaluga.scientific.unit.ErgPerSecond
import com.splendo.kaluga.scientific.unit.FootPoundForce
import com.splendo.kaluga.scientific.unit.FootPoundForcePerMinute
import com.splendo.kaluga.scientific.unit.FootPoundForcePerSecond
import com.splendo.kaluga.scientific.unit.FootPoundal
import com.splendo.kaluga.scientific.unit.Gigajoule
import com.splendo.kaluga.scientific.unit.Gigawatt
import com.splendo.kaluga.scientific.unit.GigawattHour
import com.splendo.kaluga.scientific.unit.Hectojoule
import com.splendo.kaluga.scientific.unit.Hectowatt
import com.splendo.kaluga.scientific.unit.HectowattHour
import com.splendo.kaluga.scientific.unit.Horsepower
import com.splendo.kaluga.scientific.unit.HorsepowerHour
import com.splendo.kaluga.scientific.unit.Hour
import com.splendo.kaluga.scientific.unit.ImperialEnergy
import com.splendo.kaluga.scientific.unit.InchOunceForce
import com.splendo.kaluga.scientific.unit.InchPoundForce
import com.splendo.kaluga.scientific.unit.Joule
import com.splendo.kaluga.scientific.unit.Kilojoule
import com.splendo.kaluga.scientific.unit.Kilowatt
import com.splendo.kaluga.scientific.unit.KilowattHour
import com.splendo.kaluga.scientific.unit.MeasurementSystem
import com.splendo.kaluga.scientific.unit.Megajoule
import com.splendo.kaluga.scientific.unit.Megawatt
import com.splendo.kaluga.scientific.unit.MegawattHour
import com.splendo.kaluga.scientific.unit.MetricEnergy
import com.splendo.kaluga.scientific.unit.MetricMultipleUnit
import com.splendo.kaluga.scientific.unit.Microjoule
import com.splendo.kaluga.scientific.unit.Microwatt
import com.splendo.kaluga.scientific.unit.MicrowattHour
import com.splendo.kaluga.scientific.unit.Millijoule
import com.splendo.kaluga.scientific.unit.Milliwatt
import com.splendo.kaluga.scientific.unit.MilliwattHour
import com.splendo.kaluga.scientific.unit.Minute
import com.splendo.kaluga.scientific.unit.Nanojoule
import com.splendo.kaluga.scientific.unit.Nanowatt
import com.splendo.kaluga.scientific.unit.NanowattHour
import com.splendo.kaluga.scientific.unit.Second
import com.splendo.kaluga.scientific.unit.Time
import com.splendo.kaluga.scientific.unit.Watt
import com.splendo.kaluga.scientific.unit.WattHour
import com.splendo.kaluga.scientific.unit.imperial
import com.splendo.kaluga.scientific.unit.metric
import kotlin.jvm.JvmName

@JvmName("wattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, WattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Watt.metric.power(this, time)

@JvmName("nanowattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, NanowattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Nanowatt.power(this, time)

@JvmName("microwattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, MicrowattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Microwatt.power(this, time)

@JvmName("milliwattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, MilliwattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Milliwatt.power(this, time)

@JvmName("centiwattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, CentiwattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Centiwatt.power(this, time)

@JvmName("deciwattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, DeciwattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Deciwatt.power(this, time)

@JvmName("decawattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, DecawattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Decawatt.power(this, time)

@JvmName("hectowattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, HectowattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Hectowatt.power(this, time)

@JvmName("kilowattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, KilowattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Kilowatt.power(this, time)

@JvmName("megawattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, MegawattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Megawatt.power(this, time)

@JvmName("gigawattHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, GigawattHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Gigawatt.power(this, time)

@JvmName("jouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Joule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Watt.metric.power(this, time)

@JvmName("nanojouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Nanojoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Nanowatt.metric.power(this, time)

@JvmName("microjouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Microjoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Microwatt.metric.power(this, time)

@JvmName("millijouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Millijoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Milliwatt.metric.power(this, time)

@JvmName("centijouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Centijoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Centiwatt.metric.power(this, time)

@JvmName("decijouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Decijoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Deciwatt.metric.power(this, time)

@JvmName("decajouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Decajoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Decawatt.metric.power(this, time)

@JvmName("hectojouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Hectojoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Hectowatt.metric.power(this, time)

@JvmName("kilojouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Kilojoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Kilowatt.metric.power(this, time)

@JvmName("megajouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Megajoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Megawatt.metric.power(this, time)

@JvmName("gigajouleDivTime")
infix operator fun <TimeUnit : Time> ScientificValue<MeasurementType.Energy, Gigajoule>.div(time: ScientificValue<MeasurementType.Time, TimeUnit>) =
    Gigawatt.metric.power(this, time)

@JvmName("ergDivSecond")
infix operator fun ScientificValue<MeasurementType.Energy, Erg>.div(time: ScientificValue<MeasurementType.Time, Second>) =
    ErgPerSecond.metric.power(this, time)

@JvmName("ergMultipleDivSecond")
infix operator fun <ErgUnit> ScientificValue<MeasurementType.Energy, ErgUnit>.div(time: ScientificValue<MeasurementType.Time, Second>) where ErgUnit : Energy, ErgUnit : MetricMultipleUnit<MeasurementSystem.Metric, MeasurementType.Energy, Erg> =
    ErgPerSecond.power(this, time)

@JvmName("metricEnergyDivTime")
infix operator fun <EnergyUnit : MetricEnergy, TimeUnit : Time> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    time: ScientificValue<MeasurementType.Time, TimeUnit>
) = Watt.power(this, time)

@JvmName("footPoundalDivSecond")
infix operator fun ScientificValue<MeasurementType.Energy, FootPoundal>.div(time: ScientificValue<MeasurementType.Time, Second>) =
    FootPoundForcePerSecond.power(this, time)

@JvmName("footPoundalDivMinute")
infix operator fun ScientificValue<MeasurementType.Energy, FootPoundal>.div(time: ScientificValue<MeasurementType.Time, Minute>) =
    FootPoundForcePerMinute.power(this, time)

@JvmName("footPoundForceDivSecond")
infix operator fun ScientificValue<MeasurementType.Energy, FootPoundForce>.div(time: ScientificValue<MeasurementType.Time, Second>) =
    FootPoundForcePerSecond.power(this, time)

@JvmName("footPoundForceDivMinute")
infix operator fun ScientificValue<MeasurementType.Energy, FootPoundForce>.div(time: ScientificValue<MeasurementType.Time, Minute>) =
    FootPoundForcePerMinute.power(this, time)

@JvmName("inchPoundForceDivSecond")
infix operator fun ScientificValue<MeasurementType.Energy, InchPoundForce>.div(time: ScientificValue<MeasurementType.Time, Second>) =
    FootPoundForcePerSecond.power(this, time)

@JvmName("inchPoundForceDivMinute")
infix operator fun ScientificValue<MeasurementType.Energy, InchPoundForce>.div(time: ScientificValue<MeasurementType.Time, Minute>) =
    FootPoundForcePerMinute.power(this, time)

@JvmName("inchOunceForceDivSecond")
infix operator fun ScientificValue<MeasurementType.Energy, InchOunceForce>.div(time: ScientificValue<MeasurementType.Time, Second>) =
    FootPoundForcePerSecond.power(this, time)

@JvmName("inchOunceForceDivMinute")
infix operator fun ScientificValue<MeasurementType.Energy, InchOunceForce>.div(time: ScientificValue<MeasurementType.Time, Minute>) =
    FootPoundForcePerMinute.power(this, time)

@JvmName("horepowerHourDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, HorsepowerHour>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    Horsepower.power(this, time)

@JvmName("britishThermalUnitDivHour")
infix operator fun ScientificValue<MeasurementType.Energy, BritishThermalUnit>.div(time: ScientificValue<MeasurementType.Time, Hour>) =
    BritishThermalUnitPerHour.power(this, time)

@JvmName("britishThermalUnitDivMinute")
infix operator fun ScientificValue<MeasurementType.Energy, BritishThermalUnit>.div(time: ScientificValue<MeasurementType.Time, Minute>) =
    BritishThermalUnitPerMinute.power(this, time)

@JvmName("britishThermalUnitDivSecond")
infix operator fun ScientificValue<MeasurementType.Energy, BritishThermalUnit>.div(time: ScientificValue<MeasurementType.Time, Second>) =
    BritishThermalUnitPerSecond.power(this, time)

@JvmName("imperialEnergyDivTime")
infix operator fun <EnergyUnit : ImperialEnergy, TimeUnit : Time> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    time: ScientificValue<MeasurementType.Time, TimeUnit>
) = Watt.imperial.power(this, time)

@JvmName("energyDivTime")
infix operator fun <EnergyUnit : Energy, TimeUnit : Time> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    time: ScientificValue<MeasurementType.Time, TimeUnit>
) = Watt.power(this, time)
