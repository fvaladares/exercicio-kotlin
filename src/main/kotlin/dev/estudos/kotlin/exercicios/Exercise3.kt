package dev.estudos.kotlin.exercicios

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

/**
 * @author Fabricio Valadares
 * LocalizaLabs
 *
 * Faça um algoritmo que leia a data de nascimento de uma pessoa expressa no formato (DD/MM/AAAA),
 * e mostre-a expressa apenas em dias (todos os dias de vida).
 */


fun main() {
//    val msg = """Faça um algoritmo que leia a data de nascimento de uma pessoa expressa no formato (DD/MM/AAAA) e
//        |mostre-a expressa apenas em dias (todos os dias de vida).""".trimMargin()
//
//    println(msg)
//
//    print("Please, informe a date in format dd/MM/yyyy: ")
//    val dataString = readLine()
//    val date = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
//    println(ChronoUnit.DAYS.between(date, LocalDate.now()))
//    println()
//    println("String: $dataString")
//    println("Converted: $date")
}

class Exercise3() {
    fun giveNumberOfDaysFromAnStringDateddMMyyyy(dateString: String): Long {
        val msg = """Faça um algoritmo que leia a data de nascimento de uma pessoa expressa no formato (DD/MM/AAAA) e 
        |mostre-a expressa apenas em dias (todos os dias de vida).""".trimMargin()

        println(msg)
        val date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        return (ChronoUnit.DAYS.between(date, LocalDate.now()))
    }
}