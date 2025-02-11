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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

@JvmName("reciprocalUndefinedAValueDivReciprocalUndefinedAXWrappedUndefinedBValue")
fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit : ScientificUnit<DenominatorReciprocalRightQuantity>,
    WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
    DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
    DenominatorReciprocalRightValue : ScientificValue<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
    factory: (Decimal, DenominatorReciprocalRightUnit) -> DenominatorReciprocalRightValue,
) = right.unit.inverse.right.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalUndefinedAValueDivMetricAndImperialReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricReciprocalUndefinedAValueDivMetricReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialReciprocalUndefinedAValueDivImperialReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalUndefinedAValueDivUKImperialReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalUndefinedAValueDivUSCustomaryReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalUndefinedAValueDivMetricAndUKImperialReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalUndefinedAValueDivMetricAndUSCustomaryReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit,
    NumeratorUnit,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit,
    WrappedDenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) where
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(right) {
            value: Decimal,
            unit: DenominatorReciprocalRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericReciprocalUndefinedAValueDivGenericReciprocalUndefinedAXWrappedUndefinedBValue")
infix operator fun <
    NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
    DenominatorReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalRightUnit : AbstractScientificUnit<DenominatorReciprocalRightQuantity>,
    WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>, WrappedDenominatorReciprocalRightUnit>,
    DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>, DenominatorReciprocalUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, UndefinedQuantityType.Extended<DenominatorReciprocalRightQuantity>>>, DenominatorUnit>,
) = div(right) {
        value: Decimal,
        unit: DenominatorReciprocalRightUnit,
    ->
    DefaultScientificValue(value, unit)
}
