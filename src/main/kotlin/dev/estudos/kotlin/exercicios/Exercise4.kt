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

    println(convertDaysInYearDaysMonths(nDays = nDays))
}


/**
 * @param nDays
 * @return String
 * Receives the number of days (int) and return a string with the number of years, months and days
 * */
fun convertDaysInYearDaysMonths(nDays: Int): String {
    val year = 365
    val month = 30
    val numberYears = nDays / year
    val numberMonths = (nDays % year) / month
    val numberDays = (nDays % year) % month

    val message = """
        Years: $numberYears
        Months: $numberMonths
        Days: $numberDays
    """.trimIndent()

    return (message)
}