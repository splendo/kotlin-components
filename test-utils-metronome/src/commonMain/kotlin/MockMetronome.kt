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

package com.splendo.kaluga.test.metronome

import com.splendo.kaluga.metronome.Metronome
import com.splendo.kaluga.metronome.MetronomeSettings
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration

class MockMetronome(val settings: MetronomeSettings, val timer: Flow<Duration>) : Metronome {

    class MockedMethods(metronome: MockMetronome) {
        val run = metronome::run.mock()
    }

    class Builder : Metronome.Builder {

        class MockedMethods(builder: Builder) {
            val intervalMetronome = builder::metronome.mock()
        }

        val mock = MockedMethods(this)

        private val _builtMetronomes = mutableListOf<MockMetronome>()
        val builtMetronomes: List<MockMetronome> get() = _builtMetronomes.toList()

        init {
            mock.intervalMetronome.on().doExecute { (interval, timer) ->
                MockMetronome(interval, timer).also {
                    _builtMetronomes.add(it)
                }
            }
        }

        override fun metronome(settings: MetronomeSettings, timer: Flow<Duration>): Metronome = mock.intervalMetronome.call(settings, timer)
    }

    class Manager : Metronome.Manager {

        class MockedMethods(manager: Manager) {
            val prepare = manager::prepare.mock()
            val close = manager::close.mock()
        }

        val mock = MockedMethods(this)
        val defaultBuilder = Builder()

        init {
            mock.prepare.on().doReturn(defaultBuilder)
        }

        override suspend fun prepare(): Metronome.Builder = mock.prepare.call()
        override fun close(): Unit = mock.close.call()
    }

    val mock = MockedMethods(this)

    override suspend fun run(): Unit = mock.run.call()
}
