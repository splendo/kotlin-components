/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.example.shared.viewmodel.featureList

import com.splendo.kaluga.architecture.navigation.NavigationAction
import com.splendo.kaluga.architecture.navigation.Navigator
import com.splendo.kaluga.architecture.observable.observableOf
import com.splendo.kaluga.architecture.viewmodel.NavigatingViewModel
import com.splendo.kaluga.resources.localized

actual val showPlatformSpecificFeatures: Boolean = true

sealed class PlatformFeatureListNavigationAction : NavigationAction<Nothing>(null) {
    object Compose : PlatformFeatureListNavigationAction()
}

sealed class PlatformFeature(val title: String) {
    object Compose : PlatformFeature("feature_platform_specific_compose".localized())
}

class PlatformSpecificFeaturesViewModel(
    navigator: Navigator<PlatformFeatureListNavigationAction>
) : NavigatingViewModel<PlatformFeatureListNavigationAction>(navigator) {

    val feature = observableOf(
        listOf(
            PlatformFeature.Compose
        )
    )

    fun onFeaturePressed(feature: PlatformFeature) {
        navigator.navigate(
            when (feature) {
                is PlatformFeature.Compose -> PlatformFeatureListNavigationAction.Compose
            }
        )
    }
}
