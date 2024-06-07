/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.base.utils

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * A default implementation of [BaseTimeZone].
 */
actual class KalugaTimeZone internal constructor(internal val timeZone: java.util.TimeZone) : BaseTimeZone() {

    actual companion object {

        /**
         * Gets a [KalugaTimeZone] based on a given Identifier
         * @param identifier The identifier to create a [KalugaTimeZone] for
         * @return The [KalugaTimeZone] corresponding to the identifier, if it exists. Check [availableIdentifiers] for supported identifiers
         */
        actual fun get(identifier: String): KalugaTimeZone? {
            return java.util.TimeZone.getTimeZone(identifier)?.let {
                KalugaTimeZone(it)
            }
        }

        /**
         * Gets the current [KalugaTimeZone] configured by the user
         * @return The current [KalugaTimeZone] of the user
         */
        actual fun current(): KalugaTimeZone {
            return KalugaTimeZone(java.util.TimeZone.getDefault())
        }

        /**
         * List of available identifiers associated with [KalugaTimeZone]s. All elements in this list can be used for creating a [KalugaTimeZone] using [KalugaTimeZone.get]
         */
        actual val availableIdentifiers get() = java.util.TimeZone.getAvailableIDs().asList()
    }

    actual override val identifier: String = timeZone.id
    actual override fun displayName(style: TimeZoneNameStyle, withDaylightSavings: Boolean, locale: KalugaLocale): String {
        val styleJava = when (style) {
            TimeZoneNameStyle.Short -> java.util.TimeZone.SHORT
            TimeZoneNameStyle.Long -> java.util.TimeZone.LONG
        }
        return timeZone.getDisplayName(withDaylightSavings, styleJava, locale.locale)
    }
    actual override val offsetFromGMT = timeZone.rawOffset.milliseconds
    actual override val daylightSavingsOffset = timeZone.dstSavings.milliseconds
    actual override fun offsetFromGMTAtDate(date: KalugaDate): Duration = timeZone.getOffset(date.durationSinceEpoch.inWholeMilliseconds).milliseconds
    actual override fun usesDaylightSavingsTime(date: KalugaDate): Boolean = timeZone.inDaylightTime(date.date)
    actual override fun copy(): KalugaTimeZone = KalugaTimeZone(timeZone.clone() as java.util.TimeZone)
    override fun equals(other: Any?): Boolean {
        return (other as? KalugaTimeZone)?.let { timeZone == other.timeZone } ?: false
    }

    override fun hashCode(): Int = timeZone.hashCode()
}
