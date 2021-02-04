package dev.estudos.kotlin.exercicios.pessoas.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class PessoaTest {
    lateinit var pessoa: Pessoa

    @Test
    fun calcIMC() {
        val imc: BigDecimal

        try {
            imc = pessoa.calcIMC()
            assertEquals(BigDecimal.ZERO, imc)
        } catch (e: IllegalStateException) {
            println()
            println("---| ${e.message} |---")
            println()
        }

    }

    @Test
    fun testPessoa() {

        val pessoa2 = Pessoa.create(
            name = "Test User",
            birthday = "16/11/1982",
            phone = "31 993576193",
            cpf = "AAAAAAAAAAA",
            rg = "mg00111222",
            address = Address(
                "Rua Dama da Noite",
                "200",
                "Morada dos hibiscos",
                "Pedro Leopoldo",
                "MG"
            ),
        )

        println(pessoa)
        println(pessoa2)
        println(pessoa2 == pessoa)

    }


    @BeforeEach
    fun init() {
        pessoa = Pessoa.create(
            name = "Test User",
            birthday = "16/11/1982",
            phone = "31 993576193",
            cpf = "00011122233",
            rg = "mg00111222",
            address = Address(
                "Rua Dama da Noite",
                "200",
                "Morada dos hibiscos",
                "Pedro Leopoldo",
                "MG"
            ),
        )
    }
}