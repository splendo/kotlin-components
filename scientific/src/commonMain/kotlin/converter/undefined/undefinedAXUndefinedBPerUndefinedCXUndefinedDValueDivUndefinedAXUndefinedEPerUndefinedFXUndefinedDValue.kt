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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

@JvmName("undefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
    TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit, DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit>,
    TargetDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
    TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>, TargetNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>, TargetDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
    numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit: NumeratorNumeratorRightUnit.(DenominatorDenominatorLeftUnit) -> TargetNumeratorUnit,
    numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit: NumeratorDenominatorLeftUnit.(DenominatorNumeratorRightUnit) -> TargetDenominatorUnit,
    targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit(
    right.unit.denominator.left,
).targetNumeratorUnitPerTargetDenominatorUnit(
    unit.denominator.left.numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit(right.unit.numerator.right),
).byDividing(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndImperialUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivImperialUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUKImperialUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUSCustomaryUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUKImperialUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUSCustomaryUndefinedAXUndefinedEPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
