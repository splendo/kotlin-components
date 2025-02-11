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
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

@JvmName("wrappedUndefinedAPerUndefinedBXUndefinedCValueDivReciprocalUndefinedCXUndefinedBValue")
fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit : ScientificUnit<NumeratorNumeratorQuantity>,
    WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
    DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
    NumeratorNumeratorValue : ScientificValue<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
    factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue,
) = unit.numerator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialWrappedUndefinedAPerUndefinedBXUndefinedCValueDivMetricAndImperialReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricWrappedUndefinedAPerUndefinedBXUndefinedCValueDivMetricReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialWrappedUndefinedAPerUndefinedBXUndefinedCValueDivImperialReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialWrappedUndefinedAPerUndefinedBXUndefinedCValueDivUKImperialReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryWrappedUndefinedAPerUndefinedBXUndefinedCValueDivUSCustomaryReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialWrappedUndefinedAPerUndefinedBXUndefinedCValueDivMetricAndUKImperialReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryWrappedUndefinedAPerUndefinedBXUndefinedCValueDivMetricAndUSCustomaryReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericWrappedUndefinedAPerUndefinedBXUndefinedCValueDivGenericReciprocalUndefinedCXUndefinedBValue")
infix operator fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
    WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
    DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) = div(right) {
        value: Decimal,
        unit: NumeratorNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
