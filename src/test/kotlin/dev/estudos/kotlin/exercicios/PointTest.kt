package dev.estudos.kotlin.exercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PointTest {

    @Test
    @DisplayName("P1(1,10), P2(30, 50), expected 49.40648")
    fun distanceTo() {
        val p1 = Point(1, 10)

        val result = p1.distanceTo(Point(30, 50))
        assertEquals(49.40648, result, 0.0001)
    }
}