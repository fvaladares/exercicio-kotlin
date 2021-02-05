package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Address
import dev.estudos.kotlin.exercicios.pessoas.model.Person
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull

internal class PeopleRepositoryTest {

    /**
     * Mock data (begin)
     */
    private val peopleList by lazy {
        mutableListOf<Person>()
    }

    private lateinit var person: Person
    private lateinit var person2: Person
    private lateinit var repository: PeopleRepository

    @BeforeEach
    fun init() {
        person = Person.create(
            name = "Test User",
            birthday = "16/11/1982",
            phone = "31 993576193",
            cpf = "27132713321",
            rg = "mg00111222",
            address = Address(
                "Rua Dama da Noite",
                "200",
                "Morada dos hibiscos",
                "Pedro Leopoldo",
                "MG"
            ),
        )

        person2 = Person.create(
            name = "Test User",
            birthday = "16/11/1982",
            phone = "31 993576193",
            cpf = "98765432101",
            rg = "mg00111222",
            address = Address(
                "Rua Dama da Noite",
                "200",
                "Morada dos hibiscos",
                "Pedro Leopoldo",
                "MG"
            ),
        )

        val alphabet = 'A'..'Z'
        for (i in 0..25) {
            peopleList.add(
                Person.create(
                    name = "${alphabet.elementAt(i)}user Name",
                    birthday = if (i < 10) "16/11/198$i" else "16/11/19$i",
                    phone = "31 93576193$i",
                    cpf = if (i < 10) "2111111333$i" else "111111111$i",
                    rg = "mg0011122$i",
                    address = Address(
                        "Rua Dama da Noite",
                        "i",
                        "Morada dos hibiscos",
                        "Pedro Leopoldo",
                        "MG"
                    ),
                ),
            )
        }

        repository = PeopleRepository()
        repository.addAll(people = peopleList)
    }

    @AfterEach
    private fun cleanUp() {
        repository = PeopleRepository()
    }

    /**
     * Mock data (end)
     */


    @Test
    @DisplayName("Try to add one person (new one)")
    fun addNew1() {
        with(repository) {
            assertDoesNotThrow {
                add(person)
            }

            assertDoesNotThrow {
                add(person2)
            }
        }
    }


    @Test
    @DisplayName("Test the return of getAll method")
    fun getAll() {
        val newPeopleList = repository.getAll()
        Assertions.assertEquals(peopleList, newPeopleList)

        newPeopleList.forEach {
            println(listOf(it).map {
                it
            }.joinToString("\n"))
        }
//        println(newPeopleList.joinToString("\n"))
    }

    @Test
    @DisplayName("findCPF with a valid value")
    fun findByCPFValidCPF() {
        val cpf = "21111113333"
        val localPerson = repository.findByCPF(cpf)
        assertAll(
            "Testing the findByCPF method",
            { assertNotNull(localPerson) },
            { assertEquals(cpf, localPerson.first().cpf) }
        )

    }

    @Test
    @DisplayName("findCPF with an invalid value")
    fun findByCPFInvalidCPF() {
        val cpf = ""
        val person = repository.findByCPF(cpf)
        assertNotNull(person)
        assertEquals(0, person.size)
    }

    @Test
    fun findBy() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun getById() {
    }

    @Test
    fun findByName() {
    }

}