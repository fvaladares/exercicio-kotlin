package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Pessoa

class PessoaRepository {

    private val peopleList = mutableListOf<Pessoa>()


    fun add(pessoa: Pessoa): PessoaRepository {
        TODO("Check if the CPF field is Unique")
        return this
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

    fun findBy(searc: (p: Pessoa) -> Boolean): List<Pessoa> {
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