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

package com.splendo.kaluga.media

import com.splendo.kaluga.media.DefaultSoundPlayer.State.Foreground
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.AVFAudio.AVAudioEngine
import platform.AVFAudio.AVAudioPlayerNode
import platform.AVFAudio.AVAudioFile
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.AVAudioSessionRouteChangeNotification
import platform.Foundation.NSBundle
import platform.Foundation.NSError
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSNotificationName
import platform.Foundation.NSOperationQueue.Companion.currentQueue
import platform.Foundation.NSOperationQueue.Companion.mainQueue
import platform.Foundation.NSURL
import platform.UIKit.UIApplicationDidEnterBackgroundNotification
import platform.UIKit.UIApplicationWillEnterForegroundNotification

actual class DefaultSoundPlayer actual constructor(source: MediaSource.Local) : SoundPlayer {
    private val file = accessFile(source)

    init {
        observeNotifications()
    }

    sealed interface State {
        fun enterBackground(): State
        fun enterForeground(mediaPlayerBuilder: () -> SoundPlayer): State
        fun changeRoute(mediaPlayerBuilder: () -> SoundPlayer): State
        fun finish(): State

        data class Foreground(val mediaPlayer: SoundPlayer) : State {
            override fun enterBackground() = Background
            override fun enterForeground(mediaPlayerBuilder: () -> SoundPlayer) = Foreground(mediaPlayer)
            override fun changeRoute(mediaPlayerBuilder: () -> SoundPlayer) = Foreground(mediaPlayerBuilder())
            override fun finish() = Finished
        }
        data object Background : State {
            override fun enterBackground() = Background
            override fun enterForeground(mediaPlayerBuilder: () -> SoundPlayer) = Foreground(mediaPlayerBuilder())
            override fun changeRoute(mediaPlayerBuilder: () -> SoundPlayer) = Background
            override fun finish() = Finished
        }
        data object Finished : State {
            override fun enterBackground() = Finished
            override fun enterForeground(mediaPlayerBuilder: () -> SoundPlayer) = Finished
            override fun changeRoute(mediaPlayerBuilder: () -> SoundPlayer) = Finished
            override fun finish() = Finished
        }
    }

    private var state: State = Foreground(ForegroundMetronomeMediaPlayer())
    private inline fun <reified T : State> ifState(block: T.() -> Unit) {
        (state as? T)?.block()
    }

    inner class ForegroundMetronomeMediaPlayer : SoundPlayer {
        private val node = AVAudioPlayerNode()

        private val audioEngine = AVAudioEngine().apply {
            attachNode(node)
            connect(node, outputNode, file.processingFormat)
            prepare()
            execute(
                block = { errorPtr ->
                    startAndReturnError(errorPtr)
                },
                handleError = { error ->
                    MediaSoundError.CannotStartAudioEngine(error.localizedDescription)
                },
            ).also {
                prepareAudioSession()
            }

            node.play()
        }

        private fun prepareAudioSession() {
            val audioSession = AVAudioSession.sharedInstance()
            execute(
                block = { errorPtr ->
                    // Play audio in silent mode
                    audioSession.setCategory(AVAudioSessionCategoryPlayback, errorPtr)
                },
                handleError = { error ->
                    MediaSoundError.CannotSetAudioSessionConfiguration(error.localizedDescription)
                },
            )
        }

        override fun close() {
            node.stop()
            audioEngine.stop()
            audioEngine.reset()
        }

        override fun play() {
            node.scheduleFile(file, null, null)
        }
    }

    actual override fun close() {
        ifState<Foreground> {
            mediaPlayer.close()
        }
        state = state.finish()
    }

    actual override fun play() {
        ifState<Foreground> {
            mediaPlayer.play()
        }
    }

    private fun observeNotifications() {
        observeNotification(UIApplicationDidEnterBackgroundNotification) {
            ifState<Foreground> {
                mediaPlayer.close()
            }
            state = state.enterBackground()
        }
        observeNotification(UIApplicationWillEnterForegroundNotification) {
            state = state.enterForeground {
                ForegroundMetronomeMediaPlayer()
            }
        }

        // Based on Apple documentation we should not play on speaker if user unplugged headphones
        // Responding to audio route changes: https://developer.apple.com/documentation/avfaudio/responding-to-audio-route-changes
        observeNotification(AVAudioSessionRouteChangeNotification) {
            state = state.changeRoute {
                ForegroundMetronomeMediaPlayer()
            }
        }
    }

    private fun observeNotification(name: NSNotificationName, onNotification: (NSNotification?) -> Unit) = NSNotificationCenter.defaultCenter.addObserverForName(
        name,
        null,
        currentQueue ?: mainQueue,
        onNotification,
    )

    private fun accessFile(source: MediaSource.Local): AVAudioFile = execute(
        block = { errorPtr ->
            val path = when (source) {
                is MediaSource.Bundle -> NSBundle.mainBundle.pathForResource(source.fileName, source.fileType)
                else -> error("Should be bundle")
            }

            require(path != null) { "Invalid file for sound" }
            val url = NSURL.fileURLWithPath(path)
            AVAudioFile(forReading = url, error = errorPtr)
        },
        handleError = { error ->
            MediaSoundError.CannotAccessMediaFile(error.localizedDescription)
        },
    )

    private fun <R> execute(block: (CPointer<ObjCObjectVar<NSError?>>) -> R, handleError: (error: NSError) -> MediaSoundError) = memScoped {
        val errorPtr: CPointer<ObjCObjectVar<NSError?>> = alloc<ObjCObjectVar<NSError?>>().ptr
        val result = block(errorPtr)
        val error: NSError? = errorPtr.pointed.value
        if (error != null) {
            throw handleError(error)
        } else {
            result
        }
    }
}
