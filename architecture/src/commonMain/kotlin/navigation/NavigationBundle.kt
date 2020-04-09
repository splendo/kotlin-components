/*
 Copyright 2020 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.architecture.navigation

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

sealed class NavigationBundleValue<T> {

    abstract val value: T

    data class BooleanValue internal constructor(override val value: Boolean) : NavigationBundleValue<Boolean>()
    data class BooleanArrayValue internal constructor(override val value: BooleanArray) : NavigationBundleValue<BooleanArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as BooleanArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class ByteValue internal constructor(override val value: Byte) : NavigationBundleValue<Byte>()
    data class ByteArrayValue internal constructor(override val value: ByteArray) : NavigationBundleValue<ByteArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as ByteArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }
    data class BundleValue<R: NavigationBundleSpecRow<*>> internal constructor(override val value: NavigationBundle<R>) : NavigationBundleValue<NavigationBundle<R>>()
    data class CharValue internal constructor(override val value: Char) : NavigationBundleValue<Char>()
    data class CharArrayValue internal constructor(override val value: CharArray) : NavigationBundleValue<CharArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as CharArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class CharSequenceValue internal constructor(override val value: CharSequence) : NavigationBundleValue<CharSequence>()
    data class DoubleValue internal constructor(override val value: Double) : NavigationBundleValue<Double>()
    data class DoubleArrayValue internal constructor(override val value: DoubleArray) : NavigationBundleValue<DoubleArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as DoubleArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class FloatValue internal constructor(override val value: Float) : NavigationBundleValue<Float>()
    data class FloatArrayValue internal constructor(override val value: FloatArray) : NavigationBundleValue<FloatArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as FloatArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class IntegerValue internal constructor(override val value: Int) : NavigationBundleValue<Int>()
    data class IntegerArrayValue internal constructor(override val value: IntArray) : NavigationBundleValue<IntArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as IntegerArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class LongValue internal constructor(override val value: Long) : NavigationBundleValue<Long>()
    data class LongArrayValue internal constructor(override val value: LongArray) : NavigationBundleValue<LongArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as LongArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class SerializedValue<T> internal constructor(val serializer: KSerializer<T>, override val value: T): NavigationBundleValue<T>() {

        companion object {
            private val json = Json(JsonConfiguration.Stable)
        }

        val valueString: String = json.stringify(serializer, value)
    }

    data class ShortValue internal constructor(override val value: Short) : NavigationBundleValue<Short>()
    data class ShortArrayValue internal constructor(override val value: ShortArray) : NavigationBundleValue<ShortArray>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as ShortArrayValue

            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int {
            return value.contentHashCode()
        }
    }

    data class StringValue internal constructor(override val value: String) : NavigationBundleValue<String>()
    data class StringArrayValue internal constructor(override val value: List<String>) : NavigationBundleValue<List<String>>()

    data class OptionalValue<T> internal constructor(val optionalValue: NavigationBundleValue<T>?) : NavigationBundleValue<T?>() {
        override val value: T? = optionalValue?.value
    }

}

class NavigationBundleGetError: Exception()

class NavigationBundle<R : NavigationBundleSpecRow<*>> (val spec: NavigationBundleSpec<R>, internal val values: Map<R, NavigationBundleValue<*>>) {

    fun <V, S : NavigationBundleSpecRow<V>> get(row: S): V {
        row as? R ?: throw NavigationBundleGetError()
        val value = values[row] as? NavigationBundleValue<V> ?: throw NavigationBundleGetError()
        return value.value
    }

}