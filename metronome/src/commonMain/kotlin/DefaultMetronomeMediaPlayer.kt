package com.splendo.kaluga.metronome

import com.splendo.kaluga.media.MediaSource

expect class DefaultMetronomeMediaPlayer(source: MediaSource) : MetronomeMediaPlayer {
    override fun close()
    override fun play()
}
