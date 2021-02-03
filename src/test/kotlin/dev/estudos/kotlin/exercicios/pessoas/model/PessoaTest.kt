package dev.estudos.kotlin.exercicios.pessoas.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class PessoaTest {
    var pessoa: Pessoa = Pessoa()

    @Test
    fun calcIMC() {
        assertEquals(BigDecimal.ZERO, pessoa.calcIMC())
    }

}