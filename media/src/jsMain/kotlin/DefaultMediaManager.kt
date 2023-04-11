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

package com.splendo.kaluga.media

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration

/**
 * A media that can be played by a [MediaPlayer]
 * @property source the [MediaSource] on which the media is found
 * @property duration the [Duration] of the media
 * @property currentPlayTime gets the [Duration] of playtime at the time this property is requested
 * @property resolution a [Flow] of the [Resolution] of the media. Note that if no [MediaSurface] has been bound to the media, this will be [Resolution.ZERO]
 * @property tracks a list of [TrackInfo] of the media
 */
actual class PlayableMedia(actual val source: MediaSource) {
    actual val duration: Duration = Duration.ZERO
    actual val currentPlayTime: Duration = Duration.ZERO
    actual val tracks: List<TrackInfo> = emptyList()
    actual val resolution: Flow<Resolution> = flowOf(Resolution.ZERO)
}

/**
 * Default implementation of [BaseMediaManager]
 * @param mediaSurfaceProvider a [MediaSurfaceProvider] that will automatically call [renderVideoOnSurface] for the latest [MediaSurface]
 * @param coroutineContext the [CoroutineContext] on which the media will be managed
 */
actual class DefaultMediaManager(mediaSurfaceProvider: MediaSurfaceProvider?, coroutineContext: CoroutineContext) : BaseMediaManager(mediaSurfaceProvider, coroutineContext) {

    /**
     * Builder for creating a [DefaultMediaManager]
     */
    class Builder : BaseMediaManager.Builder {
        override fun create(mediaSurfaceProvider: MediaSurfaceProvider?, coroutineContext: CoroutineContext): DefaultMediaManager = DefaultMediaManager(mediaSurfaceProvider, coroutineContext)
    }

    private var mediaSurface: MediaSurface? = null
    override var volume: Float = 0.0f

    override fun handleCreatePlayableMedia(source: MediaSource): PlayableMedia = PlayableMedia(source)

    override fun initialize(playableMedia: PlayableMedia) {
        handlePrepared(playableMedia)
    }

    override fun renderVideoOnSurface(surface: MediaSurface?) {
        this.mediaSurface = surface
    }

    override fun play(rate: Float) {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun startSeek(duration: Duration) {
        TODO("Not yet implemented")
    }

    override fun cleanUp() {
        TODO("Not yet implemented")
    }

    override fun handleReset() {
        TODO("Not yet implemented")
    }
}
