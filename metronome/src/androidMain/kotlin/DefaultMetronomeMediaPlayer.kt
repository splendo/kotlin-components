package com.splendo.kaluga.metronome

import android.media.AudioAttributes
import android.media.SoundPool
import com.splendo.kaluga.media.MediaSource
import java.net.URL

// TODO: Make sure it works in the app
// As at the moment we don't have only iOS application, it was not possible to test metronome.
// Code was tested in a separate sandbox and it seems to work
// The audio file we are using on iOS (metronome_sound.mp3) doesn't seem to work on android
// Converting mp3 into wav fixed the problem

actual class DefaultMetronomeMediaPlayer actual constructor(source: MediaSource) : MetronomeMediaPlayer {

    private val soundPool = SoundPool.Builder().apply {
        val attributes = AudioAttributes.Builder().apply {
            setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        }.build()
        setAudioAttributes(attributes)
    }.build()

    private val soundId: Int = soundPool.load(source)

    actual override fun play() {
        soundPool.play(soundId, 1F, 1F, 1, 0, 1F)
    }

    actual override fun close() {
        soundPool.release()
    }

    private fun SoundPool.load(source: MediaSource): Int = if (source is MediaSource.Url) load(source.url) else throw MetronomeError.UnexpectedMediaSourceShouldBeURL

    private fun SoundPool.load(url: URL): Int = if (url.path != null) load(url.path, 1) else throw MetronomeError.CannotAccessMediaSource
}
