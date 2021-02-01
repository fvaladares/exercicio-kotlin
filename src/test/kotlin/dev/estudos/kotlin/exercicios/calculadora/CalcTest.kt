package dev.estudos.kotlin.exercicios.calculadora

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CalcTest {

    @Test
    @DisplayName("Add 25 + 99 = 124")
    fun operationCase1() {
        Assertions.assertEquals(124.0, Calc.operation(Calc.add(25.0, 99.0)))
    }

    @Test
    @DisplayName("Add -15 + -8 = -23")
    fun operationCase2() {
        Assertions.assertEquals(-23.0, Calc.operation(Calc.add(-15.0, -8.0)))
    }

    @Test
    @DisplayName("Add 1.5 + 2.2 = 3.7")
    fun operationCase3() {
        Assertions.assertEquals(3.7, Calc.operation(Calc.add(1.5, 2.2)))
    }

    @Test
    @DisplayName("Add -10.1 + 5 = -5.1")
    fun operationCase4() {
        Assertions.assertEquals(-5.1, Calc.operation(Calc.add(-10.1, 5.0)))
    }
}