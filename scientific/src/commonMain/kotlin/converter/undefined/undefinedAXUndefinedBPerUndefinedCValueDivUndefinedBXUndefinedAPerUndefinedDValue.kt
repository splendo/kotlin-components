/*
 Copyright 2023 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.scientific.converter.undefined

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

@JvmName("undefinedAXUndefinedBPerUndefinedCValueDivUndefinedBXUndefinedAPerUndefinedDValue")
fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<DenominatorDenominatorQuantity, DenominatorDenominatorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorDenominatorQuantity, NumeratorDenominatorQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
    denominatorDenominatorUnitPerNumeratorDenominatorUnit: DenominatorDenominatorUnit.(NumeratorDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerNumeratorDenominatorUnit(unit.denominator).byDividing(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCValueDivMetricAndImperialUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCValueDivMetricUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCValueDivImperialUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCValueDivUKImperialUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCValueDivUSCustomaryUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCValueDivMetricAndUKImperialUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCValueDivMetricAndUSCustomaryUndefinedBXUndefinedAPerUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        denominatorDenominatorUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
