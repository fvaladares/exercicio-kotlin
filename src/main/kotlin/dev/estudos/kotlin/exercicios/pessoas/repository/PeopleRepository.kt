package dev.estudos.kotlin.exercicios.pessoas.repository

import dev.estudos.kotlin.exercicios.pessoas.model.Person
import dev.estudos.kotlin.exercicios.pessoas.util.fail
import java.util.logging.Logger

class PeopleRepository {


    // This class is used to generate an auto incremented id for people
    private class IdGenerator {
        private var id = 0
        fun newId(): Int = id++

    }

    private val peopleList = mutableListOf<Person>()
    private val log = Logger.getLogger(javaClass.toString())
    private val message = """### STARTING LOG   ***< %s >*** ###
        """.trimIndent()
    private val id = IdGenerator()


    /**
     * Try to add a Person
     *      * and returns a reference to it self
     *      * or an Exception, if the CPF was used before.
     */
    fun add(person: Person): PeopleRepository {

        cpfWasUsedBefore(person.cpf).also {
            when {
                it -> {
                    person.id = id.newId()
                    peopleList.add(person)
                }
                else -> fail(".| This CPF was used before. |.")
            }
        }

        return this
    }

    fun addAll(people: List<Person>) {
        for (person in people) {
            person.id = id.newId()
        }
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

    // Returns an immutable list with all people
    @Throws(IllegalStateException::class)
    fun getAll(): List<Person> {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))
        return this.peopleList.toList()
    }

    /**
     * Search a person by ID
     *
     * @return Person
     * @param id
     * @throws NoSuchElementException::class
     */
    @Throws(NoSuchElementException::class)
    fun getById(id: Int): Person {

        log.info(message.format("""
            PeopleRepository.getById()
            
            ID = $id
            
            peopleList size: $peopleList
            
            ***""".trimIndent()))
        return peopleList.first { it.id == id }
    }


    /**
     * Search people by name
     * @return list of Person
     * @param name
     * @throws IllegalStateException::class
     * @throws NoSuchElementException::class
     *
     *
     */
    @Throws(IllegalStateException::class, NoSuchElementException::class)
    fun findByName(name: String): List<Person> {
        if (peopleList.isEmpty()) throw (IllegalStateException("The list is empty"))

        val filteredList = peopleList.filter {
            it.name.equals(name, ignoreCase = true)
        }

        log.info(message.format("""
             
            PeopleRepository.findByName()
            
            NAME = $name, peopleList size: ${peopleList.size} """.trimIndent()))

        return when {
            filteredList.isNotEmpty() -> filteredList
            else -> throw(NoSuchElementException("Value not found. Named informed: $name"))
        }


    }


    /**
     *
     * @param cpf
     * @return Person
     * @throws IllegalStateException::class
     */
    fun findByCPF(cpf: String): Person {
        if (peopleList.isEmpty()) throw (IllegalStateException("The list is empty"))
        return peopleList.first { it.cpf == cpf }
    }

    // TODO("Implement")
    fun findBy(search: (p: Person) -> Boolean): List<Person> {
        if (peopleList.isEmpty()) throw (IllegalStateException("The list is empty"))
        return emptyList()
    }


    fun update(person: Person): Boolean {
        if (isEmpty()) throw (IllegalStateException("The list is empty"))

        val tempPerson = peopleList.find {
            it.id == person.id
        } ?: throw NoSuchElementException("Invalid ID, Person not found.")

        val index = peopleList.indexOf(tempPerson)

        peopleList[index] = person

        return true
    }

    fun delete(id: Int): Boolean {
        if (peopleList.isEmpty()) throw (IllegalStateException("The list is empty"))
        return try {
            peopleList.remove(getById(id))
        } catch (e: NoSuchElementException) {
            false
        }
    }

}