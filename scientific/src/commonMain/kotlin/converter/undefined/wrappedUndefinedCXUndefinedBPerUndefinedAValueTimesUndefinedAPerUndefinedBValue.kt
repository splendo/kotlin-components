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

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

@JvmName("metricAndImperialWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesMetricAndImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesMetricUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    right times this

@JvmName("imperialWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("ukImperialWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesUKImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("usCustomaryWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesUSCustomaryUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricAndUKImperialWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesMetricAndUKImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("metricAndUSCustomaryWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesMetricAndUSCustomaryUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("genericWrappedUndefinedCXUndefinedBPerUndefinedAValueTimesGenericUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
    WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, WrappedLeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
    RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftNumeratorLeftQuantity>, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) = right times this
