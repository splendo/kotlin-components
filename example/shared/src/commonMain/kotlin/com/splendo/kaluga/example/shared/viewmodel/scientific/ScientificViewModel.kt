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

package com.splendo.kaluga.example.shared.viewmodel.scientific

import com.splendo.kaluga.alerts.Alert
import com.splendo.kaluga.alerts.BaseAlertPresenter
import com.splendo.kaluga.alerts.buildActionSheet
import com.splendo.kaluga.architecture.navigation.NavigationBundleSpecType
import com.splendo.kaluga.architecture.navigation.Navigator
import com.splendo.kaluga.architecture.navigation.SingleValueNavigationAction
import com.splendo.kaluga.architecture.observable.toInitializedObservable
import com.splendo.kaluga.architecture.observable.toInitializedSubject
import com.splendo.kaluga.architecture.viewmodel.NavigatingViewModel
import com.splendo.kaluga.base.text.NumberFormatStyle
import com.splendo.kaluga.base.text.NumberFormatter
import com.splendo.kaluga.base.utils.toDecimal
import com.splendo.kaluga.example.shared.model.scientific.QuantityDetails
import com.splendo.kaluga.example.shared.model.scientific.allPhysicalQuantities
import com.splendo.kaluga.example.shared.model.scientific.details
import com.splendo.kaluga.example.shared.model.scientific.name
import com.splendo.kaluga.example.shared.stylable.ButtonStyles
import com.splendo.kaluga.resources.view.KalugaButton
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.unit.ScientificUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ScientificConverterNavigationAction(val quantity: PhysicalQuantity, val index: Int) : SingleValueNavigationAction<ScientificConverterViewModel.Arguments>(
    ScientificConverterViewModel.Arguments(quantity, index),
    NavigationBundleSpecType.SerializedType(ScientificConverterViewModel.Arguments.serializer())
)

class ScientificViewModel(
    val alertPresenterBuilder: BaseAlertPresenter.Builder,
    navigator: Navigator<ScientificConverterNavigationAction>
) : NavigatingViewModel<ScientificConverterNavigationAction>(navigator) {

    companion object {
        val numberFormatterDecimal = NumberFormatter(style = NumberFormatStyle.Decimal(maxIntegerDigits = 10U, minIntegerDigits = 1U, minFractionDigits = 0U, maxFractionDigits = 10U))
        val numberFormatterScientific = NumberFormatter(style = NumberFormatStyle.Scientific())
    }

    private val quantityDetails = allPhysicalQuantities.mapNotNull { it.details }
    private val currentQuantityDetails = MutableStateFlow(quantityDetails.firstOrNull())
    val quantityDetailsButton = currentQuantityDetails.map { createQuantityButton(it) }.toInitializedObservable(createQuantityButton(null), coroutineScope)
    private val units = currentQuantityDetails.map { it?.units ?: emptySet() }.stateIn(coroutineScope, SharingStarted.Eagerly, emptySet())
    private val currentLeftUnit = MutableStateFlow<ScientificUnit<*>?>(null)
    val currentLeftUnitButton = currentLeftUnit.map { createLeftUnitButton(it) }.toInitializedObservable(createLeftUnitButton(null), coroutineScope)
    private val currentRightUnit = MutableStateFlow<ScientificUnit<*>?>(null)
    val currentRightUnitButton = currentRightUnit.map { createRightUnitButton(it) }.toInitializedObservable(createRightUnitButton(null), coroutineScope)
    private val _leftValue = MutableStateFlow("0.0")
    val leftValue = _leftValue.toInitializedSubject(coroutineScope)
    private val _rightValue = MutableStateFlow("0.0")
    val rightValue = _rightValue.toInitializedObservable(coroutineScope)

    val converters = currentQuantityDetails.map { details ->
        details?.let {
            details.converters.mapIndexed { index, converter ->
                KalugaButton.Plain(converter.name, ButtonStyles.default) {
                    navigator.navigate(ScientificConverterNavigationAction(details.quantity, index))
                }
            }
        }.orEmpty()
    }.toInitializedObservable(emptyList(), coroutineScope)

    init {
        coroutineScope.launch {
            units.collect {
                currentLeftUnit.value = it.firstOrNull()
                currentRightUnit.value = it.firstOrNull()
            }
        }
    }

    val calculateButton = KalugaButton.Plain("Calculate", ButtonStyles.default) {
        val details = currentQuantityDetails.value
        val left = numberFormatterScientific.parse(_leftValue.value)?.toDecimal()
        val leftUnit = currentLeftUnit.value
        val rightUnit = currentRightUnit.value
        _rightValue.value = if (details != null && left != null && leftUnit != null && rightUnit != null) {
            details.convert(left, leftUnit, rightUnit)?.let { result ->
                val formattedDecimal = numberFormatterDecimal.format(result.value)
                val parsedDecimal = numberFormatterDecimal.parse(formattedDecimal)
                val formatter = if (parsedDecimal?.toDouble() == result.value.toDouble()) {
                    numberFormatterDecimal
                } else {
                    numberFormatterScientific
                }
                formatter.format(result.value)
            }.orEmpty()
        } else {
            ""
        }
    }

    private fun createQuantityButton(currentQuantityDetails: QuantityDetails<*>?) = KalugaButton.Plain(currentQuantityDetails?.let { it.quantity::class.simpleName }.orEmpty(), ButtonStyles.default) { selectQuantity() }

    private fun selectQuantity() {
        coroutineScope.launch {
            alertPresenterBuilder.buildActionSheet(coroutineScope) {
                setTitle("Select Quantity")
                addActions(quantityDetails.map { Alert.Action(it.quantity::class.simpleName.orEmpty()) { currentQuantityDetails.value = it } })
            }.show()
        }
    }

    private fun createLeftUnitButton(currentUnit: ScientificUnit<*>?) = KalugaButton.Plain(currentUnit?.symbol.orEmpty(), ButtonStyles.default) { selectUnit(currentLeftUnit) }

    private fun createRightUnitButton(currentUnit: ScientificUnit<*>?) = KalugaButton.Plain(currentUnit?.symbol.orEmpty(), ButtonStyles.default) { selectUnit(currentRightUnit) }

    private fun selectUnit(saveTo: MutableStateFlow<ScientificUnit<*>?>) {
        coroutineScope.launch {
            alertPresenterBuilder.buildActionSheet(coroutineScope) {
                setTitle("Select Unit")
                addActions(units.value.map { Alert.Action(it.name) { saveTo.value = it } })
            }.show()
        }
    }
}
