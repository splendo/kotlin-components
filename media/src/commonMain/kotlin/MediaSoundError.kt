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

sealed class MediaSoundError(message: String) : Error(message) {
    data object UnexpectedMediaSourceShouldBeURL : MediaSoundError("Unexpected media source type. Should be URL.")
    data object UnexpectedMediaSourceShouldBeId : MediaSoundError("Unexpected media source type. Should be Id.")
    data object CannotAccessMediaSource : MediaSoundError("Cannot access media source.")
    class CannotAccessMediaFile(detailedDescription: String? = null) : MediaSoundError("Cannot access media file. $detailedDescription")
    class CannotStartAudioEngine(detailedDescription: String? = null) : MediaSoundError("Cannot start audio engine. $detailedDescription")
    class CannotSetAudioSessionConfiguration(detailedDescription: String? = null) : MediaSoundError("Failed to set the audio session configuration. $detailedDescription")
}
