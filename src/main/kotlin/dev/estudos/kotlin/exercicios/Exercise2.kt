package dev.estudos.kotlin.exercicios

import kotlin.math.pow

fun main() {

    val msg = """
    Escreva um algoritmo que leia três números inteiros e positivos (A, B, C) e calcule a seguinte expressão:

    D = (R + S) / 2 
    R = (A + B)²
    S = (B + C)²
""".trimIndent()

    println(msg)
    println("Please inform the values of A, B and C.")
    println("Insert one by line.")
    val a = readInt()
    val b = readInt()
    val c = readInt()

    val d = D(a, b, c)

    println("D value is: ${d.calcD()}")


}


class D(private val a: Int, private val b: Int, private val c: Int) {
    fun calcD(): Double {
        return (
                ((a + b).toDouble().pow(2) +
                        (b + c).toDouble().pow(2)) / 2
                )
    }
}