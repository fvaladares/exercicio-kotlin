package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Pessoa
import dev.estudos.kotlin.exercicios.pessoas.util.fail

class PessoaRepository {

    private val peopleList = mutableListOf<Pessoa>()


    /**
     * Try to add a Person
     *      * and returns a reference to it self
     *      * or an Exception, if the CPF was used before.
     */
    fun add(pessoa: Pessoa): PessoaRepository {

        cpfValidation(pessoa.cpf).also {
            when {
                it -> peopleList.add(pessoa)
                else -> fail(".| This CPF was used before. |.")
            }
        }

        return this
    }


    /**
     *  This method check if the informed CPF is valid according to the specification
     *      * 11 int long
     *      ** If the informed cpf is in the list, it will return false otherwise true
     */
    private fun cpfValidation(cpf: String): Boolean {
        val validator = peopleList.filter {
            it.cpf == cpf
        }

        return validator.isEmpty()
    }


    fun getAll(): MutableList<Pessoa> {
        return this.peopleList
    }


    fun getById(id: Int): Pessoa {
        TODO("Filter people by id")
        return TODO()
    }

    fun findByName(nome: String): List<Pessoa> {
        return TODO("Filter people by name")
    }

    fun findByCPF(cpf: String): List<Pessoa> {
        return TODO("Create the CPF filter")
    }

    fun findBy(search: (p: Pessoa) -> Boolean): List<Pessoa> {
        TODO("Create a filter that accepts a lambda expression")
        return emptyList()
    }

    fun update(pessoa: Pessoa): Boolean {
        TODO("Implement the update function")
        return false
    }

    fun delete(id: Int): Boolean {
        TODO("Implement the delete function")
        return false
    }
}