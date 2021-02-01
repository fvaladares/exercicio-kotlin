package dev.estudos.kotlin.exercicios.calculadora

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CalcTest {

    @Test
    @DisplayName("Add 4 + 2, expecting result 6")
    fun operationCase1() {
        Assertions.assertEquals(6.0, Calc.operation(Calc.add(4.0, 2.0)))
    }

    @Test
    @DisplayName("Add -4 + 2, expecting result -4")
    fun operationCase2() {
        Assertions.assertEquals(-2.0, Calc.operation(Calc.add(-4.0, 2.0)))
    }
}