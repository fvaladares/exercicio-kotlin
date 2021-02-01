package dev.estudos.kotlin.exercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Exercise3Test {

    @Test
    fun giveNumberOfDaysFromAnStringDateddMMyyyy() {
        val e3Date = Exercise3()

        assertEquals(13957, e3Date.giveNumberOfDaysFromAnStringDateddMMyyyy("16/11/1982"))
    }
}