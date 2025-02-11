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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

@JvmName("reciprocalUndefinedAXUndefinedBValueDivUndefinedCPerUndefinedBXUndefinedAValue")
fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
    NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
    NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
    DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
    TargetUnit : UndefinedReciprocalUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<DenominatorNumeratorQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
    reciprocalTargetUnit: DenominatorNumeratorUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalUndefinedAXUndefinedBValueDivMetricAndImperialUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalUndefinedAXUndefinedBValueDivMetricUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalUndefinedAXUndefinedBValueDivImperialUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalUndefinedAXUndefinedBValueDivUKImperialUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalUndefinedAXUndefinedBValueDivUSCustomaryUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalUndefinedAXUndefinedBValueDivMetricAndUKImperialUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalUndefinedAXUndefinedBValueDivMetricAndUSCustomaryUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
