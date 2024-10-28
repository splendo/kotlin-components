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

@file:JvmName("AndroidKalugaColor")

package com.splendo.kaluga.resources

import androidx.annotation.ColorInt

actual sealed class KalugaColor {
    @get:ColorInt
    abstract val currentColor: Int

    actual data class RGBColor(@ColorInt val color: Int) : KalugaColor() {
        override val currentColor: Int = color
    }

    actual data class DarkLightColor(actual val defaultColor: RGBColor, actual val darkColor: RGBColor = defaultColor) : KalugaColor() {
        constructor(@ColorInt defaultColor: Int, @ColorInt darkModeColor: Int = defaultColor) : this(RGBColor(defaultColor), RGBColor(darkModeColor))
        @get:ColorInt
        override val currentColor: Int get() = if (isInDarkMode) {
            darkColor
        } else {
            defaultColor
        }.currentColor
    }

}

/**
 * Gets the red value of the color in a range between `0.0` and `1.0`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.red: Double get() = redInt.toDouble() / 255.0

/**
 * Gets the red value of the color in a range between `0` and `255`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.redInt: Int get() = android.graphics.Color.red(currentColor)

/**
 * Gets the green value of the color in a range between `0.0` and `1.0`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.green: Double get() = greenInt.toDouble() / 255.0

/**
 * Gets the green value of the color in a range between `0` and `255`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.greenInt: Int get() = android.graphics.Color.green(currentColor)

/**
 * Gets the blue value of the color in a range between `0.0` and `1.0`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.blue: Double get() = blueInt.toDouble() / 255.0

/**
 * Gets the blue value of the color in a range between `0` and `255`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.blueInt: Int get() = android.graphics.Color.blue(currentColor)

/**
 * Gets the alpha value of the color in a range between `0.0` and `1.0`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.alpha: Double get() = alphaInt.toDouble() / 255.0

/**
 * Gets the alpha value of the color in a range between `0` and `255`. Value will be respective to whether [isInDarkMode].
 */
actual val KalugaColor.RGBColor.alphaInt: Int get() = android.graphics.Color.alpha(currentColor)

/**
 * Creates a [KalugaColor] using red, green, blue, and (optional) alpha, all ranging between `0.0` and `1.0`.
 * @param red The red color value ranging between `0.0` and `1.0`.
 * @param green The green color value ranging between `0.0` and `1.0`.
 * @param blue The blue color value ranging between `0.0` and `1.0`.
 * @param alpha The alpha color value ranging between `0.0` and `1.0`. Defaults to `1.0`
 * @return The [KalugaColor] with the corresponding red, green, blue, and alpha values
 */
actual fun colorFrom(red: Double, green: Double, blue: Double, alpha: Double): KalugaColor.RGBColor =
    KalugaColor.RGBColor(android.graphics.Color.argb((alpha * 255.0).toInt(), (red * 255.0).toInt(), (green * 255.0).toInt(), (blue * 255.0).toInt()))

/**
 * Creates a [KalugaColor] using red, green, blue, and (optional) alpha, all ranging between `0` and `255`.
 * @param redInt The red color value ranging between `0` and `255`.
 * @param greenInt The green color value ranging between `0` and `255`.
 * @param blueInt The blue color value ranging between `0` and `255`.
 * @param alphaInt The alpha color value ranging between `0` and `255`. Defaults to `255`
 * @return The [KalugaColor] with the corresponding red, green, blue, and alpha values
 */
actual fun colorFrom(redInt: Int, greenInt: Int, blueInt: Int, alphaInt: Int): KalugaColor.RGBColor = KalugaColor.RGBColor(android.graphics.Color.argb(alphaInt, redInt, greenInt, blueInt))

/**
 * Creates a [KalugaColor] that uses [darkModeColor] when [isInDarkMode] and this color otherwise.
 * If this color has a dark mode already it will be overwritten.
 * If [darkModeColor] has a dark mode, it will be used.
 * @param darkModeColor the [KalugaColor] to use when [isInDarkMode]
 * @return a [KalugaColor] that supports a custom color in dark mode.
 */
actual infix fun KalugaColor.RGBColor.withDarkMode(darkModeColor: KalugaColor.RGBColor): KalugaColor.DarkLightColor = KalugaColor.DarkLightColor(this, darkModeColor)
