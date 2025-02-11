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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

@JvmName("undefinedAXUndefinedBPerUndefinedCValueTimesUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit : ScientificUnit<RightNumeratorRightQuantity>,
    WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
    RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
    RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
    RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
    RightNumeratorRightValue : ScientificValue<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
    factory: (Decimal, RightNumeratorRightUnit) -> RightNumeratorRightValue,
) = right.unit.numerator.right.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCValueTimesMetricAndImperialUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCValueTimesMetricUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCValueTimesImperialUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCValueTimesUKImperialUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCValueTimesUSCustomaryUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCValueTimesMetricAndUKImperialUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCValueTimesMetricAndUSCustomaryUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit,
    LeftUnit,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit,
    WrappedRightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericUndefinedAXUndefinedBPerUndefinedCValueTimesGenericUndefinedCXWrappedUndefinedDPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
    LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit>,
    RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
    WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
    RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorAndRightNumeratorLeftQuantity, LeftDenominatorAndRightNumeratorLeftUnit, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>, WrappedRightNumeratorRightUnit>,
    RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
    RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorLeftQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorAndRightNumeratorLeftQuantity, UndefinedQuantityType.Extended<RightNumeratorRightQuantity>>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) = times(right) {
        value: Decimal,
        unit: RightNumeratorRightUnit,
    ->
    DefaultScientificValue(value, unit)
}
