package dev.estudos.kotlin.exercicios.pessoas.model

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertNotNull
import java.math.BigDecimal

internal class PersonTest {
    private lateinit var person: Person

    @BeforeEach
    fun init() {
        person = Person.create(
            name = "Just a Name",
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

    @Test
    @DisplayName("user don't set the height and weight")
    fun testCalcIMCFailWeightHeight() {
        val msg = assertThrows<Exception> {
            person.calcIMC()
        }
        println(msg.message)
    }

    @Test
    @DisplayName("user don't set the height")
    fun testCalcIMCFailHeight() {
        person.weight = BigDecimal(84.00)
        val msg = assertThrows<Exception> {
            person.calcIMC()
        }
        println(msg.message)
    }


    @Test
    @DisplayName("user don't set the weight")
    fun testCalcIMCFailWeight() {
        person.height = BigDecimal(1.87)
        val msg = assertThrows<Exception> {
            person.calcIMC()
        }
        println(msg.message)
    }

    @Test
    @DisplayName("user set the height and weight")
    fun testCalcIMCPass() {
        person.weight = BigDecimal(84.00)
        person.height = BigDecimal(1.87)
        assertDoesNotThrow {
            person.calcIMC()
        }
    }

    @Test
    @DisplayName("Check if the object was created correctly")
    fun testPessoaPass() {
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
        assertAll(
            "Testing if the person object will be created.",
            {
                assertNotNull(pessoa2)
            },
        )

        println(pessoa2)
    }

    @Test
    @DisplayName("Test phone exception")
    fun testPessoaFailPhone() {
        var pessoa2: Person
        assertThrows<ExceptionInInitializerError> {
            pessoa2 = Person.create(
                name = "Test User",
                birthday = "16/11/1982",
                phone = "31 999357-6193", // invalid phone number
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
            println(pessoa2)
        }
    }


    /**
     * Input	Result
    A L	(Incorreto)
    A L Sousa	(Incorreto)
    Ada Li	(Correto)
    Ada li	(Incorreto)
    Ada L	(Incorreto)
    Ada L Sousa	(Correto
     */

    @Test
    @DisplayName("Test the exception when the name do not match with the pattern")
    fun testNameFail() {
        var pessoa2: Person
        assertThrows<ExceptionInInitializerError> {
            pessoa2 = Person.create(
                name = "f g valadares",
                birthday = "16/11/1982",
                phone = "31 99357-6193",
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
            println(pessoa2)
        }
    }


}