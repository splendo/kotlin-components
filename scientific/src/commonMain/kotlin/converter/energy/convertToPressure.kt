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
import com.splendo.kaluga.scientific.converter.pressure.pressure
import com.splendo.kaluga.scientific.unit.Barye
import com.splendo.kaluga.scientific.unit.CubicCentimeter
import com.splendo.kaluga.scientific.unit.CubicFoot
import com.splendo.kaluga.scientific.unit.Energy
import com.splendo.kaluga.scientific.unit.Erg
import com.splendo.kaluga.scientific.unit.FootPoundForce
import com.splendo.kaluga.scientific.unit.FootPoundal
import com.splendo.kaluga.scientific.unit.ImperialEnergy
import com.splendo.kaluga.scientific.unit.ImperialVolume
import com.splendo.kaluga.scientific.unit.MeasurementSystem
import com.splendo.kaluga.scientific.unit.MetricAndImperialEnergy
import com.splendo.kaluga.scientific.unit.MetricEnergy
import com.splendo.kaluga.scientific.unit.MetricMultipleUnit
import com.splendo.kaluga.scientific.unit.MetricVolume
import com.splendo.kaluga.scientific.unit.Pascal
import com.splendo.kaluga.scientific.unit.PoundSquareFoot
import com.splendo.kaluga.scientific.unit.PoundSquareInch
import com.splendo.kaluga.scientific.unit.UKImperialVolume
import com.splendo.kaluga.scientific.unit.USCustomaryVolume
import com.splendo.kaluga.scientific.unit.Volume
import kotlin.jvm.JvmName

@JvmName("ergDivCubicCentimeter")
infix operator fun ScientificValue<MeasurementType.Energy, Erg>.div(volume: ScientificValue<MeasurementType.Volume, CubicCentimeter>) =
    Barye.pressure(this, volume)

@JvmName("ergMultipleDivCubicCentimeter")
infix operator fun <ErgUnit> ScientificValue<MeasurementType.Energy, ErgUnit>.div(volume: ScientificValue<MeasurementType.Volume, CubicCentimeter>) where ErgUnit : Energy, ErgUnit : MetricMultipleUnit<MeasurementSystem.Metric, MeasurementType.Energy, Erg> =
    Barye.pressure(this, volume)

@JvmName("metricEnergyDivMetricVolume")
infix operator fun <EnergyUnit : MetricEnergy, VolumeUnit : MetricVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = Pascal.pressure(this, volume)

@JvmName("footPoundalDivCubicFoot")
infix operator fun ScientificValue<MeasurementType.Energy, FootPoundal>.div(volume: ScientificValue<MeasurementType.Volume, CubicFoot>) =
    PoundSquareFoot.pressure(this, volume)

@JvmName("footPoundForceDivCubicFoot")
infix operator fun ScientificValue<MeasurementType.Energy, FootPoundForce>.div(volume: ScientificValue<MeasurementType.Volume, CubicFoot>) =
    PoundSquareFoot.pressure(this, volume)

@JvmName("imperialEnergyDivImperialVolume")
infix operator fun <EnergyUnit : ImperialEnergy, VolumeUnit : ImperialVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = PoundSquareInch.pressure(this, volume)

@JvmName("metricAndImperialEnergyDivImperialVolume")
infix operator fun <EnergyUnit : MetricAndImperialEnergy, VolumeUnit : ImperialVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = PoundSquareInch.pressure(this, volume)

@JvmName("imperialEnergyDivUKImperialVolume")
infix operator fun <EnergyUnit : ImperialEnergy, VolumeUnit : UKImperialVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = PoundSquareInch.pressure(this, volume)

@JvmName("imperialEnergyDivUSCustomaryVolume")
infix operator fun <EnergyUnit : ImperialEnergy, VolumeUnit : USCustomaryVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = PoundSquareInch.pressure(this, volume)

@JvmName("metricAndImperialEnergyDivUKImperialVolume")
infix operator fun <EnergyUnit : MetricAndImperialEnergy, VolumeUnit : UKImperialVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = PoundSquareInch.pressure(this, volume)

@JvmName("metricAndImperialEnergyDivUSCustomaryVolume")
infix operator fun <EnergyUnit : MetricAndImperialEnergy, VolumeUnit : USCustomaryVolume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = PoundSquareInch.pressure(this, volume)

@JvmName("energyDivVolume")
infix operator fun <EnergyUnit : Energy, VolumeUnit : Volume> ScientificValue<MeasurementType.Energy, EnergyUnit>.div(
    volume: ScientificValue<MeasurementType.Volume, VolumeUnit>
) = Pascal.pressure(this, volume)
