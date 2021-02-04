package dev.estudos.kotlin.exercicios.pessoas.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class PessoaTest {
    lateinit var pessoa: Pessoa

    @Test
    fun calcIMC() {
        assertEquals(BigDecimal.ZERO, pessoa.calcIMC())
    }


    @BeforeEach
    fun init() {
//        pessoa = Pessoa.createPessoa()
    }

}