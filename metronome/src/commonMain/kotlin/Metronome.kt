/*
 Copyright 2024 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.metronome

import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

interface Metronome {

    companion object {
        val TIMER_TICK_INTERVAL = 1.milliseconds
    }

    interface Builder {
        fun intervalMetronome(settings: MetronomeSettings, timer: Flow<Duration>): Metronome
    }

    interface Manager : AutoCloseable {
        suspend fun prepare(): Builder
    }

    suspend fun run()
}
