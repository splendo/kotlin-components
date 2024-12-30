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

import com.splendo.kaluga.logging.error
import com.splendo.kaluga.media.MediaSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.runningFold
import kotlin.time.Duration

class DefaultMetronome(private val settings: MetronomeSettings, private val timer: Flow<Duration>, private val mediaPlayer: MetronomeMediaPlayer) : Metronome {
    private class Builder(private val mediaPlayer: MetronomeMediaPlayer) : Metronome.Builder {
        override fun intervalMetronome(settings: MetronomeSettings, timer: Flow<Duration>) = DefaultMetronome(settings, timer, mediaPlayer)
    }

    class Manager(source: MediaSource, private val mediaPlayer: MetronomeMediaPlayer = DefaultMetronomeMediaPlayer(source)) : Metronome.Manager {

        override suspend fun prepare(): Metronome.Builder = Builder(mediaPlayer)

        override fun close() {
            mediaPlayer.close()
        }
    }

    override suspend fun run() {
        timer.runningFold<Duration, Pair<Duration?, Duration>>(
            null to settings.beatAfter(null),
        ) { (lastBeat, nextBeat), elapsed ->
            // Since timer only ticks every 1 ms, we should include the next 0.5ms as well to keep a smooth metronome
            if (elapsed < nextBeat) {
                lastBeat to nextBeat
            } else {
                nextBeat to settings.beatAfter(nextBeat)
            }
        }.filter { (lastBeat, _) -> lastBeat != null }.distinctUntilChanged().collectLatest {
            try {
                mediaPlayer.play()
            } catch (e: MetronomeError) {
                error(e)
            }
        }
    }
}
