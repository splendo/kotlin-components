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

package com.splendo.kaluga.example.shared.viewmodel.media

import com.splendo.kaluga.alerts.BaseAlertPresenter
import com.splendo.kaluga.architecture.observable.toUninitializedObservable
import com.splendo.kaluga.architecture.viewmodel.BaseLifecycleViewModel
import com.splendo.kaluga.example.shared.stylable.ButtonStyles
import com.splendo.kaluga.media.DefaultSoundPlayer
import com.splendo.kaluga.media.MediaSource
import com.splendo.kaluga.resources.asImage
import com.splendo.kaluga.resources.view.KalugaButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes

class MediaSoundViewModel : BaseLifecycleViewModel() {

    private companion object {
        const val SOUND_BPM_INITIAL = 80
        const val SOUND_BPM_STEP = 20
        const val MIN_STEPPER_VALUE = 0
        const val MAX_STEPPER_VALUE = 20
    }

    private var soundPlayer = MediaSoundLoopPlayer(coroutineScope, mediaSource = SoundsSources.beep).apply {
        updateBPM(SOUND_BPM_INITIAL)
    }
    private val playingSound = MutableStateFlow(false)
    val playStopSoundButton = playingSound.map {
        if (it) {
            KalugaButton.WithoutText(ButtonStyles.mediaButton("stop".asImage()!!)) {
                playingSound.value = false
                soundPlayer.stop()
            }
        } else {
            KalugaButton.WithoutText(ButtonStyles.mediaButton("play_arrow".asImage()!!)) {
                playingSound.value = true
                soundPlayer.play()
            }
        }
    }.toUninitializedObservable(coroutineScope)

    private val soundPlayBPM = MutableStateFlow(SOUND_BPM_INITIAL)
    private var soundBPMStepperValue = 0
    val plusBPMButton = soundPlayBPM.map {
        KalugaButton.Plain("+", ButtonStyles.default, isEnabled = soundBPMStepperValue < MAX_STEPPER_VALUE) {
            soundBPMStepperValue ++
            updateBPM(soundBPMStepperValue)
        }
    }.toUninitializedObservable(coroutineScope)

    val minusBPMButton = soundPlayBPM.map {
        KalugaButton.Plain("-", ButtonStyles.default, isEnabled = soundBPMStepperValue > MIN_STEPPER_VALUE) {
            soundBPMStepperValue --
            updateBPM(soundBPMStepperValue)
        }
    }.toUninitializedObservable(coroutineScope)

    val soundBPMLabel = soundPlayBPM.map { "$it bpm" }.toUninitializedObservable(coroutineScope)
    private fun updateBPM(value: Int) {
        soundPlayBPM.value = SOUND_BPM_INITIAL + value * SOUND_BPM_STEP
        soundPlayer.updateBPM(soundPlayBPM.value)
    }

    override fun onCleared() {
        super.onCleared()
        soundPlayer.stop()
    }
}

private class MediaSoundLoopPlayer(
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
