package dev.estudos.kotlin.exercicios

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 1.Construa um algoritmo que,tendo comodados de entrada dois pontos quaisquer no plano,
 * P(x1,y1) e P(x2,y2), escreva a distância entre eles.
 * Fórmula: d = sqrt( pow((x2-x1),2) + pow((y2-y1),2) )
 */


fun main() {

    val message = """1.Construa um algoritmo que,tendo comodados de entrada dois pontos quaisquer no plano,
    P(x1,y1) e P(x2,y2), escreva a distância entre eles.
    Fórmula: d = sqrt( pow((x2-x1),2) + pow((y2-y1),2) )""".trimIndent()

    println(message)

    val p1 = Point.create()
    val p2 = Point.create()


    p1.printPoint(1)
    p2.printPoint(2)

    println("\nThe distance between P1 and P2 is ${p1.distanceTo(p2)}")
    println("Program finished. \nThanks!!")
}


class Point(private val x: Int, private val y: Int) {
    fun distanceTo(p2: Point): Double {
        return sqrt(
            ((p2.x - this.x).toDouble().pow(2)) +
                    ((p2.y - this.y).toDouble().pow(2))
        )
    }


    fun printPoint(id: Int = 0) {
        println()
        println("Point $id \n Coordinates: x: ${this.x}, y: ${this.y}")
    }

    companion object {
        fun create(): Point {
            println()
            print("Please, inform the X coordinate for the new point: ")
            val x = readInt()
            println()
            print("Please, inform the Y coordinate for the new point: ")
            val y = readInt()

            return Point(x, y)
        }
    }
}

