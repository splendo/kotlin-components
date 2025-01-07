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

/**
 *  Plays a sound from [MediaSource]
 *  Meant for short low latency audio
 */
interface SoundPlayer : AutoCloseable {
    /** Plays the sound */
    fun play()
}

/**
 * A default implementation of [SoundPlayer]
*/
expect class DefaultSoundPlayer(source: MediaSource.Local) : SoundPlayer {
    override fun close()
    override fun play()
}
