package dev.estudos.kotlin.exercicios.pessoas.model

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertNotNull
import java.math.BigDecimal

internal class PersonTest {
    lateinit var person: Person

    @Test
    @DisplayName("user don't set the height and weight")
    fun calcIMCFailWeightHeight() {

        val msg = assertThrows<Exception> {
            person.calcIMC()
        }
        println(msg.message)
    }

    @Test
    @DisplayName("user don't set the height")
    fun calcIMCFailHeight() {

        person.weight = BigDecimal(84.00)
        val msg = assertThrows<Exception> {
            person.calcIMC()
        }
        println(msg.message)
    }


    @Test
    @DisplayName("user don't set the weight")
    fun calcIMCFailWeight() {

        person.height = BigDecimal(1.87)
        val msg = assertThrows<Exception> {
            person.calcIMC()
        }
        println(msg.message)
    }

    @Test
    @DisplayName("user set the height")
    fun calcIMCPass() {
        person.weight = BigDecimal(84.00)
        person.height = BigDecimal(1.87)
        assertDoesNotThrow {
            person.calcIMC()
        }
    }

    @Test
    @DisplayName("Check if the object was created correctly")
    fun testPessoa() {

        println()
        println("1234567890".length)
        println()

        val pessoa2 = Person.create(
            name = "Test User",
            birthday = "16/11/1982",
            phone = "31 993576193",
            cpf = "01234567890",
            rg = "mg00111222",
            address = Address(
                "Rua Dama da Noite",
                "200",
                "Morada dos hibiscos",
                "Pedro Leopoldo",
                "MG"
            ),
        )
        assertNotNull(pessoa2)
        println(pessoa2)
    }


    @BeforeEach
    fun init() {
        person = Person.create(
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