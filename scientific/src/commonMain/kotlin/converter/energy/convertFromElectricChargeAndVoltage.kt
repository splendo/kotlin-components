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

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.ElectricCharge
import com.splendo.kaluga.scientific.unit.Energy
import com.splendo.kaluga.scientific.unit.Voltage
import kotlin.jvm.JvmName

@JvmName("energyFromChargeAndVoltageDefault")
fun <
    EnergyUnit : Energy,
    ChargeUnit : ElectricCharge,
    VoltageUnit : Voltage
    > EnergyUnit.energy(
    charge: ScientificValue<MeasurementType.ElectricCharge, ChargeUnit>,
    voltage: ScientificValue<MeasurementType.Voltage, VoltageUnit>
) = energy(charge, voltage, ::DefaultScientificValue)

@JvmName("energyFromChargeAndVoltage")
fun <
    EnergyUnit : Energy,
    ChargeUnit : ElectricCharge,
    VoltageUnit : Voltage,
    Value : ScientificValue<MeasurementType.Energy, EnergyUnit>
    > EnergyUnit.energy(
    charge: ScientificValue<MeasurementType.ElectricCharge, ChargeUnit>,
    voltage: ScientificValue<MeasurementType.Voltage, VoltageUnit>,
    factory: (Decimal, EnergyUnit) -> Value
) = byMultiplying(charge, voltage, factory)
