package com.splendo.kaluga.metronome

import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

interface Metronome {

    companion object {
        val TIMER_TICK_INTERVAL = 1.milliseconds
    }

    interface Builder {
        fun intervalMetronome(settings: MetronomeSettings, timer: Flow<Duration>): Metronome
    }

    interface Manager : AutoCloseable {
        suspend fun prepare(): Builder
    }

    suspend fun run()
}
