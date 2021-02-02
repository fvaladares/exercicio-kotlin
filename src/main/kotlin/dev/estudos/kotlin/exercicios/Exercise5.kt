package dev.estudos.kotlin.exercicios

class Exercise5(private val value: List<Double>, private val weight: List<Int> = listOf(2, 3, 5)) {
    fun weightedAverageNotes(): Double {
        var accumulator = 0.0
        for (item in value.zip(weight)) {
            accumulator += (item.first * item.second)
        }
        return (accumulator.toBigDecimal() / weight.sum().toBigDecimal()).toDouble()
    }
}

