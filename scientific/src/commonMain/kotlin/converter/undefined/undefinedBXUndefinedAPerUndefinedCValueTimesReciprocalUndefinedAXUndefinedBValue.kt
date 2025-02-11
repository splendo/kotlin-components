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

import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

@JvmName("metricAndImperialUndefinedBXUndefinedAPerUndefinedCValueTimesMetricAndImperialReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricUndefinedBXUndefinedAPerUndefinedCValueTimesMetricReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    right times this

@JvmName("imperialUndefinedBXUndefinedAPerUndefinedCValueTimesImperialReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("ukImperialUndefinedBXUndefinedAPerUndefinedCValueTimesUKImperialReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("usCustomaryUndefinedBXUndefinedAPerUndefinedCValueTimesUSCustomaryReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricAndUKImperialUndefinedBXUndefinedAPerUndefinedCValueTimesMetricAndUKImperialReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("metricAndUSCustomaryUndefinedBXUndefinedAPerUndefinedCValueTimesMetricAndUSCustomaryReciprocalUndefinedAXUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalRightUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightReciprocalLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this
