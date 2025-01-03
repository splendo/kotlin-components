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

import android.content.res.AssetFileDescriptor
import com.splendo.kaluga.example.shared.R
import com.splendo.kaluga.media.MediaSource
import com.splendo.kaluga.media.mediaSourceFromUrl

actual object SoundsSources {
//    actual val beep: MediaSource = mediaSourceFromUr`l("https://cdn.freesound.org/previews/459/459992_6253486-lq.mp3"```)!!
    actual val beep: MediaSource = MediaSource.Asset(
        context.getResources().openRawResourceFd(R.raw.sound)
    );
}