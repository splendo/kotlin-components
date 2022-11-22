/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.example.shared.viewmodel.architecture

import com.splendo.kaluga.architecture.navigation.NavigationBundleSpecType
import com.splendo.kaluga.architecture.navigation.Navigator
import com.splendo.kaluga.architecture.navigation.SingleValueNavigationAction
import com.splendo.kaluga.architecture.observable.InitializedObservable
import com.splendo.kaluga.architecture.observable.subjectOf
import com.splendo.kaluga.architecture.viewmodel.NavigatingViewModel
import com.splendo.kaluga.example.shared.stylable.ButtonStyles
import com.splendo.kaluga.resources.localized
import com.splendo.kaluga.resources.view.KalugaButton
import kotlinx.serialization.Serializable

@Serializable
data class InputDetails(
    val name: String,
    val number: Int
)

sealed class ArchitectureDetailsNavigationAction<T>(value: T, type: NavigationBundleSpecType<T>) : SingleValueNavigationAction<T>(value, type) {
    object Close : ArchitectureDetailsNavigationAction<Unit>(Unit, NavigationBundleSpecType.UnitType)
    class FinishWithDetails(details: InputDetails) : ArchitectureDetailsNavigationAction<InputDetails>(details, NavigationBundleSpecType.SerializedType(InputDetails.serializer()))
}

class ArchitectureDetailsViewModel(initialDetail: InputDetails, navigator: Navigator<ArchitectureDetailsNavigationAction<*>>) : NavigatingViewModel<ArchitectureDetailsNavigationAction<*>>(navigator) {

    private val _name = subjectOf(initialDetail.name)
    val name: InitializedObservable<String> = _name
    private val _number = subjectOf(initialDetail.number.toString())
    val number: InitializedObservable<String> = _number

    private var nameResult: String by _name.valueDelegate
    private var numberResult: String by _number.valueDelegate

    val inverseButton = KalugaButton.Plain("architecture_details_inverse".localized(), ButtonStyles.default) {
        nameResult = nameResult.reversed()
        numberResult = numberResult.reversed()
    }

    val finishButton = KalugaButton.Plain("architecture_finish".localized(), ButtonStyles.default) {
        navigator.navigate(ArchitectureDetailsNavigationAction.FinishWithDetails(InputDetails(nameResult, numberResult.toIntOrNull() ?: 0)))
    }

    fun onBackPressed() {
        navigator.navigate(ArchitectureDetailsNavigationAction.Close)
    }
}
