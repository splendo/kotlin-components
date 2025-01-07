/*
 Copyright 2025 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.example.shared.viewmodel.media

import com.splendo.kaluga.media.DefaultSoundPlayer
import com.splendo.kaluga.media.MediaSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes

class MediaSoundLoopPlayer(
    private val coroutineScope: CoroutineScope,
    private val mediaSource: MediaSource.Local,
    ) {

    private var player: DefaultSoundPlayer? = null

    private var isRunning = false
    private var delay: Duration = 100.milliseconds

    init {
        coroutineScope.launch {
            while (isActive) {
                delay(delay)
                if (isRunning) {
                    player?.play()
                }
            }
        }
    }


    fun play() = coroutineScope.launch {
        player = DefaultSoundPlayer(source = mediaSource)
        isRunning = true
    }

    fun stop() = coroutineScope.launch {
        isRunning = false
        player?.close()
        player = null
    }

    fun updateBPM(bpm: Int) {
        delay = 1.minutes / bpm
    }
}