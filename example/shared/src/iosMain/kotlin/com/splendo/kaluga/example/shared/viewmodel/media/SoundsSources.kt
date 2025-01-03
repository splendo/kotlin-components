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

import com.splendo.kaluga.media.MediaSource
import platform.Foundation.NSBundle
import platform.Foundation.NSURL

actual object SoundsSources {
    actual val beep: MediaSource by lazy {
        val path = NSBundle.mainBundle.pathForResource("sound", "mp3")
        require(path != null) { "Invalid file for metronome_sound" }
        MediaSource.URL(
            NSURL.fileURLWithPath(path),
            listOf(MediaSource.URL.Option.PreferPreciseDurationAndTiming(isPreferred = true)),
        )
    }
}