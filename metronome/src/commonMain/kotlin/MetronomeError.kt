package com.splendo.kaluga.metronome

sealed class MetronomeError(message: String) : Error(message) {
    data object UnexpectedMediaSourceShouldBeURL : MetronomeError("Unexpected media source type. Should be URL.")
    data object CannotAccessMediaSource : MetronomeError("Cannot access media source.")
    class CannotAccessMediaFile(detailedDescription: String? = null) : MetronomeError("Cannot access media file. $detailedDescription")
    class CannotStartAudioEngine(detailedDescription: String? = null) : MetronomeError("Cannot start audio engine. $detailedDescription")
    class CannotSetAudioSessionConfiguration(detailedDescription: String? = null) : MetronomeError("Failed to set the audio session configuration. $detailedDescription")
}
