/*
 Copyright 2020 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.links

import com.splendo.kaluga.links.manager.DefaultLinksManager
import com.splendo.kaluga.links.manager.LinksManager
import com.splendo.kaluga.links.manager.LinksStateChange
import com.splendo.kaluga.links.manager.PlatformLinksValidator
import com.splendo.kaluga.links.state.LinksStateRepo

class MockPlatformLinksStateRepoBuilder : LinksStateRepo.Builder {
    override fun create(): LinksStateRepo =
        LinksStateRepo(MockPlatformLinksManagerBuilder())
}

class MockPlatformLinksManagerBuilder : LinksManager.Builder {
    override fun create(onLinksStateChange: LinksStateChange): LinksManager =
        DefaultLinksManager(onLinksStateChange, PlatformLinksValidator())
}