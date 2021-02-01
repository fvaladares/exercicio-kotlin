package dev.estudos.kotlin.exercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DTest {

    @Test
    @DisplayName("Given a = 5, b = 3, c = 2, then d = 44.5")
    fun calcCase1() {
        val d = D(a = 5, b = 3, c = 2)
        val result = d.calcD()

        assertEquals(44.5, result)
    }

    @Test
    @DisplayName("Given a = -1, b = 0, c = 4, then d = 8.5")
    fun calcCase2() {
        val d = D(a = -1, b = 0, c = 4)
        val result = d.calcD()

        assertEquals(8.5, result)
    }
}