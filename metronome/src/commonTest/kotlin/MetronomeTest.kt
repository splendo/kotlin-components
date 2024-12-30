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

import com.splendo.kaluga.media.mediaSourceFromUrl
import com.splendo.kaluga.test.base.mock.verifyWithin
import com.splendo.kaluga.test.metronome.MetronomeMediaPlayerMock
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.ZERO
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class MetronomeTest {

    @Test
    fun runMetronome() = runTest {
        val source = mediaSourceFromUrl("https://mockmediasource.com")!!
        val mediaPlayer = MetronomeMediaPlayerMock()
        val manager = DefaultMetronome.Manager(source, mediaPlayer)
        val builder = async { manager.prepare() }
        val metronomeSettings = MetronomeSettings.Fixed(MetronomeSettings.BPM(60.0))
        val timer = MutableSharedFlow<Duration>(replay = 1)
        val metronome = builder.await().metronome(metronomeSettings, timer)
        val runJob = launch { metronome.run() }
        timer.emit(ZERO)
        mediaPlayer.mock.play.verifyWithin()

        timer.emit(1.seconds)
        mediaPlayer.mock.play.verifyWithin(times = 2)

        timer.emit(1.seconds + 999.milliseconds)
        mediaPlayer.mock.play.verifyWithin(times = 2)

        timer.emit(1.seconds + 1.seconds)
        mediaPlayer.mock.play.verifyWithin(times = 3)

        runJob.cancel()
        manager.close()
        mediaPlayer.mock.close.verifyWithin()
    }
}
