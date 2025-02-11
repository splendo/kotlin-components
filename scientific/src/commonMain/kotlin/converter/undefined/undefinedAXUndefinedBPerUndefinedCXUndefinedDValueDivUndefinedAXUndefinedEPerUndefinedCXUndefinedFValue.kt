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

@JvmName("undefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
    TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
    TargetDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
    TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>, TargetNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>, TargetDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
    numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit: NumeratorNumeratorRightUnit.(DenominatorDenominatorRightUnit) -> TargetNumeratorUnit,
    numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit: NumeratorDenominatorRightUnit.(DenominatorNumeratorRightUnit) -> TargetDenominatorUnit,
    targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit(
    right.unit.denominator.right,
).targetNumeratorUnitPerTargetDenominatorUnit(
    unit.denominator.right.numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit(right.unit.numerator.right),
).byDividing(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndImperialUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
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
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivImperialUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUKImperialUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUSCustomaryUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUKImperialUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUSCustomaryUndefinedAXUndefinedEPerUndefinedCXUndefinedFValue")
infix operator fun <
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorLeftUnit, DenominatorDenominatorRightQuantity, DenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorLeftQuantity, DenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorRightUnitXDenominatorDenominatorRightUnit = { x(it) },
        numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorNumeratorRightQuantity,
                    NumeratorNumeratorRightUnit,
                    DenominatorDenominatorRightQuantity,
                    DenominatorDenominatorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorDenominatorRightQuantity,
                    NumeratorDenominatorRightUnit,
                    DenominatorNumeratorRightQuantity,
                    DenominatorNumeratorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
