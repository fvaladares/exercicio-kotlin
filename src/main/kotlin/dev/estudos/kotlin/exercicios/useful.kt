package dev.estudos.kotlin.exercicios

import kotlin.system.exitProcess

// Convert the String from terminal in Int, or return 0 if there is some problem.
//fun readInt() = readLine()?.toIntOrNull() ?: 0

//fun readInt(): Int {
//    val valor = readLine()?.toIntOrNull()
//
//    if (valor == null) {
//        println("Invalid data, the program will be closed.")
//        exitProcess(1)
//    }
//
//    return valor
//}

/**
 * Try to read an int:
 *      If the value is empty the program will be closed.
 *       If is an invalid number, the function will be called again (recursion)
 *
 */
fun readInt(): Int {

    val valor: String = readLine().toString()

    if (valor.isBlank()) {
        println("You let the field empty. Finishing the program. Bye ;)")
        exitProcess(1)
    }

    return try {
        valor.toInt()
    } catch (e: Exception) {
        println("Please, inform a valid number.")
        readInt()
    }
}

//fun readString(): Int {
//
//    val valor: String = readLine().toString()
//
//    if (valor.isBlank()) {
//        println("You let the field empty. Finishing the program. Bye ;)")
//        exitProcess(1)
//    }
//
//    return try {
//        valor.
//    } catch (e: Exception) {
//        println("Please, inform a valid number.")
//        readInt()
//    }
//}