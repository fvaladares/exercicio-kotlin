package dev.estudos.kotlin.exercicios

fun main() {
    val doubled = CollectionsTest.test()
    println(doubled)
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
}


object CollectionsTest {
    fun test(): List<Int> {
        return List(3) { it * 2 }
    }
}