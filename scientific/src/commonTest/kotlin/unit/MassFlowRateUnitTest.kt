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

package com.splendo.kaluga.scientific.unit

import com.splendo.kaluga.scientific.assertEqualScientificValue
import com.splendo.kaluga.scientific.convert
import com.splendo.kaluga.scientific.converter.power.div
import com.splendo.kaluga.scientific.converter.weight.div
import com.splendo.kaluga.scientific.invoke
import kotlin.test.Test
import kotlin.test.assertEquals

class MassFlowRateUnitTest {

    @Test
    fun massFlowRateConversionTest() {
        assertScientificConversion(1.0, (Kilogram per Second), 132.28, Pound per Minute, 2)
    }

    @Test
    fun massFlowRateFromPowerAndSpecificEnergy() {
        assertEquals(1(Kilogram per Minute), 2(Kilocalorie per Minute) / 2(Kilocalorie per Kilogram))
        assertEquals(1(Pound per Minute), 2(Kilocalorie per Minute) / 2(Kilocalorie per Pound))
        assertEquals(1(Pound.ukImperial per Minute), 2(Kilocalorie per Minute) / 2(Kilocalorie per Pound.ukImperial))
        assertEquals(1(Pound.usCustomary per Minute), 2(Kilocalorie per Minute) / 2(Kilocalorie per Pound.usCustomary))
        assertEquals(1(Kilogram per Minute), 2(Joule per Minute) / 2(Joule per Kilogram))
        assertEquals(1(Pound per Minute), 2(FootPoundForce per Minute) / 2(FootPoundForce per Pound))
        assertEquals(1(Pound.ukImperial per Minute), 2(FootPoundForce per Minute) / 2(FootPoundForce per Pound.ukImperial))
        assertEquals(1(Pound.usCustomary per Minute), 2(FootPoundForce per Minute) / 2(FootPoundForce per Pound.usCustomary))
        assertEquals(1(Kilogram per Second), 2(Watt) / 2(Joule per Kilogram))
        assertEquals(550(Pound per Second), 2(Horsepower) / 2(FootPoundForce per Pound))
        assertEquals(550(Pound.ukImperial per Second), 2(Horsepower) / 2(FootPoundForce per Pound.ukImperial))
        assertEquals(550(Pound.usCustomary per Second), 2(Horsepower) / 2(FootPoundForce per Pound.usCustomary))
        assertEqualScientificValue(1(Kilogram per Second), 2(Watt) / 2(Joule per Kilogram).convert(FootPoundForce per Pound), 8)
    }

    @Test
    fun massFlowRateFromWeightAndAreaTest() {
        assertEquals(1(Kilogram per Second), 2(Kilogram) / 2(Second))
        assertEquals(1(Pound per Second), 2(Pound) / 2(Second))
        assertEquals(1(Pound.ukImperial per Second), 2(Pound.ukImperial) / 2(Second))
        assertEquals(1(Pound.usCustomary per Second), 2(Pound.usCustomary) / 2(Second))
        assertEqualScientificValue(1(Kilogram per Second), 2(Kilogram).convert(Pound as Weight) / 2(Second), 8)
    }
}
