package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Person
import dev.estudos.kotlin.exercicios.pessoas.util.fail
import java.util.*
import java.util.logging.Logger

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

    // Check if the list is empty
    private fun isEmpty(): Boolean {
        return peopleList.size == 0
    }

    @Throws(IllegalStateException::class)
    fun getAll(): List<Person> {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        return this.peopleList.toList()
    }

    @Throws(NoSuchElementException::class)
    fun getById(id: Int): Person {
        val log = Logger.getLogger(javaClass.toString())
        val message = """
            
            *** 
            Stating log
            
                %s
        """.trimIndent()
        log.info(message.format("""
            
            ID = $id
            
            peopleList size: $peopleList
            
            ***""".trimIndent()))
        return peopleList.first { it.id == id }
    }

    fun findByName(nome: String): List<Person> {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        return TODO("Filter people by name")
    }


    /**
     * Returns a list with the filter result
     * If the CPF was not found, the list will be empty
     */
    fun findByCPF(cpf: String): Person {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        return peopleList.first { it.cpf == cpf }
    }

    fun findBy(search: (p: Person) -> Boolean): List<Person> {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        TODO("Create a filter that accepts a lambda expression")
        return emptyList()
    }

    fun update(person: Person): Boolean {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        TODO("Implement the update function")
        return false
    }

    fun delete(id: Int): Boolean {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        TODO("Implement the delete function")
        return false
    }
}