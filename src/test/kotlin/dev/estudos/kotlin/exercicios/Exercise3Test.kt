package dev.estudos.kotlin.exercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

internal class Exercise3Test {

    @Test
//    @Disabled("O número de dias pode falhar pois o ")
    fun giveNumberOfDaysFromAnStringDateddMMyyyy() {
        val e3Date = Exercise3()

        val date = "16/11/1982"

        assertEquals(ChronoUnit.DAYS.between(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            LocalDate.now()), e3Date.giveNumberOfDaysFromAnStringDateddMMyyyy(date))
    }
}