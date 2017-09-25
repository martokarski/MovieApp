package org.mautokar.movieapp.util

import org.junit.Test
import org.junit.Assert.assertEquals

class UtilsTest {

    @Test
    fun shouldReturnFalseWhenValueIsZero() {
        val byte: Byte = 0
        assertEquals(false, byte.booleanValue)
    }

    @Test
    fun shouldReturnTrueWhenValueIsOne() {
        val byte: Byte = 1
        assertEquals(true, byte.booleanValue)
    }

    @Test
    fun shouldReturnTrueWhenValueIsNonZero() {
        val byte: Byte = 27
        assertEquals(true, byte.booleanValue)
    }
}