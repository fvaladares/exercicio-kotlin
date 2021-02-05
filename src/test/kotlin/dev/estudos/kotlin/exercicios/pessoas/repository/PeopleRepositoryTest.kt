package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Address
import dev.estudos.kotlin.exercicios.pessoas.model.Person
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PeopleRepositoryTest {

    //Mock data:

    val listOfPessoa by lazy {
        mutableListOf<Person>()
    }

    private lateinit var person: Person
    private lateinit var person2: Person

//    private val person: Person = Person.create(
//        name = "Test User",
//        birthday = "16/11/1982",
//        phone = "31 993576193",
//        cpf = "11111111111",
//        rg = "mg00111222",
//        address = Address(
//            "Rua Dama da Noite",
//            "200",
//            "Morada dos hibiscos",
//            "Pedro Leopoldo",
//            "MG"
//        ),
//    )

    //    private val person2 = Person.create(
//        name = "Test User",
//        birthday = "16/11/1982",
//        phone = "31 993576193",
//        cpf = "11111111112",
//        rg = "mg00111222",
//        address = Address(
//            "Rua Dama da Noite",
//            "200",
//            "Morada dos hibiscos",
//            "Pedro Leopoldo",
//            "MG"
//        ),
//    )
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
            listOfPessoa.add(
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
        repository.addAll(people = listOfPessoa)
    }

    @AfterEach
    private fun cleanUp() {
        repository = PeopleRepository()
    }


    @Test
    @DisplayName("Try to add one person (new one)")
    fun addNew1() {
        with(repository) {
            add(person)
            add(person2)
        }
        getAll()
        println("""
            
            
            Result filtering by CPF = ${person.cpf}            
                Result: ${findByCPF(person.cpf).joinToString("\n")}
            
            """.trimIndent())
    }

    @Test
    fun getAll() {
        println(repository.getAll().joinToString("\n"))
    }

    @Test
    fun getById() {
    }

    @Test
    fun findByName() {
    }


    private fun findByCPF(cpf: String): List<Person> {
        return repository.findByCPF(cpf)
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
}