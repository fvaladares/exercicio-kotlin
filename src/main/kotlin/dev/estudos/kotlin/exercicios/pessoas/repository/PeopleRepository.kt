package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Person
import dev.estudos.kotlin.exercicios.pessoas.util.fail

class PeopleRepository {

    private val peopleList = mutableListOf<Person>()


    /**
     * Try to add a Person
     *      * and returns a reference to it self
     *      * or an Exception, if the CPF was used before.
     */
    fun add(person: Person): PeopleRepository {

        cpfWasUsedBefore(person.cpf).also {
            when {
                it -> peopleList.add(person)
                else -> fail(".| This CPF was used before. |.")
            }
        }

        return this
    }

    fun addAll(people: List<Person>) {
        peopleList.addAll(people)
    }


    /**
     *  This method check if the informed CPF is valid according to the specification
     *      * 11 int long
     *      ** If the informed cpf is in the list, it will return false otherwise true
     */
    private fun cpfWasUsedBefore(cpf: String): Boolean {
        val validator = peopleList.filter {
            it.cpf == cpf
        }

        return validator.isEmpty()
    }


    fun getAll(): List<Person> {
        return this.peopleList.toList()
    }


    fun getById(id: Int): Person {
        TODO("Filter people by id")
        return TODO()
    }

    fun findByName(nome: String): List<Person> {
        return TODO("Filter people by name")
    }


    /**
     * Returns a list with the filter result
     * If the CPF was not found, the list will be empty
     */
    fun findByCPF(cpf: String): List<Person> {
        return peopleList.filter { it.cpf == cpf }
    }

    fun findBy(search: (p: Person) -> Boolean): List<Person> {
        TODO("Create a filter that accepts a lambda expression")
        return emptyList()
    }

    fun update(person: Person): Boolean {
        TODO("Implement the update function")
        return false
    }

    fun delete(id: Int): Boolean {
        TODO("Implement the delete function")
        return false
    }
}