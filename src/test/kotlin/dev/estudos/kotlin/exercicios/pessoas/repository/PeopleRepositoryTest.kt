package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Address
import dev.estudos.kotlin.exercicios.pessoas.model.Person
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

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
                "Morada dos hibiscus",
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
                "Morada dos hibiscus",
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
                    phone = if (i < 10) "31 93576193$i" else "31 3576-19$i",
                    cpf = if (i < 10) "2111111333$i" else "111111111$i",
                    rg = "mg0011122$i",
                    address = Address(
                        "Rua Dama da Noite",
                        "i",
                        "Morada dos hibiscus",
                        "Pedro Leopoldo",
                        "MG"
                    ),
                ),
            )
        }

        repository = PeopleRepository()
        repository.addAll(people = peopleList)

        println("""
            
            init executing...
            ${repository.getAll().size}
            
        """.trimIndent())
    }

//    @AfterEach
//    private fun cleanUp() {
//        repository = PeopleRepository()
//    }

    /**
     * Mock data (end)
     */


    @Test
    @DisplayName("Try to add one person (new one)")
    fun testAddNew1() {
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
    fun testGetAll() {
        val newPeopleList = repository.getAll()
        assertEquals(peopleList, newPeopleList)

        newPeopleList.forEach { it ->
            println(listOf(it).map {
                it
            }.joinToString("\n"))
        }
    }

    @Test
    @DisplayName("Try to get all in an empty list")
    fun testGetAllFail() {
        repository = PeopleRepository()
        assertThrows<IllegalStateException> {
            repository.getAll()
        }
    }


    @Test
    @DisplayName("findCPF with a valid value")
    fun findByCPFValidCPF() {
        val cpf = "21111113333"
        val localPerson = repository.findByCPF(cpf)
        assertAll(
            "Testing the findByCPF method",
            { assertNotNull(localPerson) },
            { assertEquals(cpf, localPerson.cpf) }
        )
    }


    @Test
    @DisplayName("findCPF with an invalid value")
    fun findByCPFInvalidCPF() {
        val cpf = ""

        assertThrows<NoSuchElementException> { repository.findByCPF(cpf) }
    }

    @Test
    fun findBy() {
    }

    @Test
    fun update() {
    }

    @Test
    fun deletePass() {
        val id = 8
        assertTrue(repository.delete(id))
    }

    @Test
    fun deleteFailInvalidId() {
        val id = 300
        assertFalse(repository.delete(id))
    }


    @Test
    fun testGetByIdPass() {
        val id = 20
//        var person: Person

        assertDoesNotThrow {
            person = repository.getById(id)
            println(person)
        }
    }

    @Test
    @DisplayName("Test getById with an invalid ID")
    fun testGetByIdFailInvalidId() {
        val id = 3599
        assertThrows<NoSuchElementException> { repository.getById(id).id }
    }


    @Test
    fun testFindByNamePass() {
        assertDoesNotThrow {
            println(repository.findByName("Auser Name"))
        }
    }

    @Test
    fun testFindByNameFail() {
        assertThrows<NoSuchElementException> {
            println(repository.findByName("Fabricio Valadares"))
        }
    }

    @Test
    fun testFindByNameFailEmptyList() {
        repository = PeopleRepository()
        assertThrows<IllegalStateException> {
            println(repository.findByName("Fabricio Valadares"))
        }
    }

}