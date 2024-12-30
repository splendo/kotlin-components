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

package com.splendo.kaluga.metronome

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.frequency.time
import com.splendo.kaluga.scientific.unit.BeatsPerMinute
import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.Duration.Companion.ZERO
import kotlin.time.Duration.Companion.minutes

sealed class MetronomeSettings {
    data object None : MetronomeSettings() {
        override fun beatAfter(lastBeat: Duration?): Duration = Duration.INFINITE
    }
    data class Fixed(val bpm: BPM) : MetronomeSettings() {
        override fun beatAfter(lastBeat: Duration?): Duration = lastBeat?.let(bpm::beatAfter) ?: ZERO
    }
    data class Increasing(val startBPM: BPM, val increaseBPM: BPM, val increaseInterval: Duration) : MetronomeSettings() {
        fun bpmAtDuration(duration: Duration): BPM {
            val timesToIncrease = (duration / increaseInterval).toInt()
            return BPM(startBPM.value + timesToIncrease * increaseBPM.value)
        }

        override fun beatAfter(lastBeat: Duration?): Duration {
            val previousBeat = lastBeat ?: return ZERO
            // First grab the BPM used at the previous beat
            val bpmAtPreviousBeat = bpmAtDuration(previousBeat)
            // Assuming this BPM calculate the next beat
            val nextBeatAssumingConstantBPM = bpmAtPreviousBeat.beatAfter(previousBeat)
            // However, BPM might increase in the mean time.
            // This may lead to three scenarios:
            // 1) The BPM is constant between the previous and next beat. Use the current BPM to calculate the next beat
            // 2) The next beat would come after the increase of the BPM for both the current and next BPM. Use the increased BPM to calculate the next beat
            // 3) The next beat would come after the increase of the BPM only if we are using the current BPM. The new beat should sound immediately when the BPM increases
            val nextIncreaseOfBPM = increaseInterval * ((previousBeat / increaseInterval).toInt() + 1)
            val nextBeatAssumingIncreaseBPM = BPM(bpmAtPreviousBeat.value + increaseBPM.value).beatAfter(previousBeat)
            return when {
                nextBeatAssumingConstantBPM < nextIncreaseOfBPM -> nextBeatAssumingConstantBPM
                nextBeatAssumingIncreaseBPM > nextIncreaseOfBPM -> nextBeatAssumingIncreaseBPM
                else -> nextIncreaseOfBPM
            }
        }
    }

    @JvmInline
    value class BPM(override val value: Double) : ScientificValue<PhysicalQuantity.Frequency, BeatsPerMinute> {
        override val unit: BeatsPerMinute
            get() = BeatsPerMinute

        init {
            require(value > 0.0) { "BPM cannot be zero or lower" }
        }

        fun beatAfter(duration: Duration) = duration + time().value.minutes
    }

    abstract fun beatAfter(lastBeat: Duration?): Duration
}
