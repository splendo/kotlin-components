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
