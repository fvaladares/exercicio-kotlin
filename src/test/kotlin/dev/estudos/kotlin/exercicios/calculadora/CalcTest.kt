package dev.estudos.kotlin.exercicios.calculadora

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalcTest {


    @ParameterizedTest
    @CsvSource(
        "10.0,  2.0,    12.0",
        "5.0,   3.0,    8.0",
        "-1.0,  -2.0,   -3.0",
        "-5.0,  5.0,    0.0"
    )
    fun operation(x: Double, y: Double, expectedAnswer: Double) {
        Assertions.assertEquals(
            expectedAnswer,
            Calc.operation(x, y) { x, y ->
                x + y
            }
        )
    }


    @Test
    fun operationFabricio() {
        Assertions.assertEquals(
            10.0,
            Calc.operation(x = 2.0, y = 8.0) { x, y ->
                x + y
            }
        )
    }
}