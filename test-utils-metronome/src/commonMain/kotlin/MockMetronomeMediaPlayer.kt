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

import com.splendo.kaluga.metronome.MetronomeMediaPlayer
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.parameters.mock

class MetronomeMediaPlayerMock : MetronomeMediaPlayer {
    class MockedMethods(private val player: MetronomeMediaPlayer) {
        val close = player::close.mock()
        val play = player::play.mock()
    }

    val mock = MockedMethods(this)

    override fun close() = mock.close.call()
    override fun play() = mock.play.call()
}
