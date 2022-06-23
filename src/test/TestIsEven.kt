package test

import org.junit.Test
import kotlin.test.assertEquals

class TestIsEven{

    @Test
    fun `test from 0 to 10000000`(){
        var isEven = true
        for (number in 0..1000000) {
            assertEquals(practice.isEven(number), isEven)
            isEven = isEven.not()
        }
    }
}