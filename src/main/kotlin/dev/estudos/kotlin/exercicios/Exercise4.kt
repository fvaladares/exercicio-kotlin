package dev.estudos.kotlin.exercicios

/**
 * Faça um algoritmo que leia a idade de uma pessoa expressa em dias e mostre-a expressa em anos, meses e dias.
 * */

fun main() {
    val msg =
        """Faça um algoritmo que leia a idade de uma pessoa expressa em dias e mostre-a expressa em anos, meses e dias."""

    println(msg)
    println("Please, inform the number of days: ")
    val nDays: Int = readInt()

    val myMap = convertDaysInYearDaysMonths(nDays = nDays)

    myMap.forEach {
        println("${it.key}: ${it.value}")
    }
}


/**
 * @param nDays
 * @return Map
 * Receives the number of days (int) and return a Map collection with the number of years, months and days
 * */
fun convertDaysInYearDaysMonths(nDays: Int): Map<String, Int> {
    val year = 365
    val month = 30
    val numberYears = nDays / year
    val numberMonths = (nDays % year) / month
    val numberDays = (nDays % year) % month

    val keys = listOf("years", "months", "days")
    val values = listOf(numberYears, numberMonths, numberDays)

    val result = keys.associateWith() {
        values[keys.indexOf(it)]
    }

    return (result)
}