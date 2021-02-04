package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Address
import dev.estudos.kotlin.exercicios.pessoas.model.Pessoa
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PessoaRepositoryTest {

    private val pessoa: Pessoa = Pessoa.create(
        name = "Test User",
        birthday = "16/11/1982",
        phone = "31 993576193",
        cpf = "11111111111",
        rg = "mg00111222",
        address = Address(
            "Rua Dama da Noite",
            "200",
            "Morada dos hibiscos",
            "Pedro Leopoldo",
            "MG"
        ),
    )
    private val pessoa2 = Pessoa.create(
        name = "Test User",
        birthday = "16/11/1982",
        phone = "31 993576193",
        cpf = "11111111112",
        rg = "mg00111222",
        address = Address(
            "Rua Dama da Noite",
            "200",
            "Morada dos hibiscos",
            "Pedro Leopoldo",
            "MG"
        ),
    )
    private val repository = PessoaRepository()

//@BeforeEach
//    fun init() {
//        pessoa = Pessoa.create(
//            name = "Test User",
//            birthday = "16/11/1982",
//            phone = "31 993576193",
//            cpf = "11111111111",
//            rg = "mg00111222",
//            address = Address(
//                "Rua Dama da Noite",
//                "200",
//                "Morada dos hibiscos",
//                "Pedro Leopoldo",
//                "MG"
//            ),
//        )
//
//        pessoa2 = Pessoa.create(
//            name = "Test User",
//            birthday = "16/11/1982",
//            phone = "31 993576193",
//            cpf = "11111111112",
//            rg = "mg00111222",
//            address = Address(
//                "Rua Dama da Noite",
//                "200",
//                "Morada dos hibiscos",
//                "Pedro Leopoldo",
//                "MG"
//            ),
//        )
//
//        repository = PessoaRepository()
//    }
//@AfterEach
//    fun cleanUp() {
//        repository = PessoaRepository()
//    }


    @Test
    @DisplayName("Try to add one person (new one)")
    fun addNew1() {
        with(repository) {
            add(pessoa)
            add(pessoa2)
        }
        getAll()
        println("""
            
            
            Result filtering by CPF = ${pessoa.cpf}            
                Result: ${findByCPF(pessoa.cpf).joinToString("\n")}
            
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

    @Test
    fun findByCPF(cpf: String): List<Pessoa> {
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