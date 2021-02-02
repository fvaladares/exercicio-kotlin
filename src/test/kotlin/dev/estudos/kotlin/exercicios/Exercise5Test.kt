package dev.estudos.kotlin.exercicios

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

internal class Exercise5Test {
    private var valuesList = mutableListOf<Exercise5>()
    private val answerList = mutableListOf<Double>()


    @Test
    fun weightedAverageNotes() {
        for (it in valuesList.zip(answerList)) {
            Assertions.assertEquals(it.second, it.first.weightedAverageNotes())
        }
//        val exercise5 = Exercise5(listOf<Double>(6.3, 7.9, 1.0))
//        val average = exercise5.weightedAverageNotes()
//
//        Assertions.assertEquals(4.13, average)
    }


    companion object {
        @BeforeAll
        fun initAll(exercise5Test: Exercise5Test) {

            exercise5Test.valuesList.apply {
                add(Exercise5(listOf(6.3, 7.9, 1.0)))
                add(Exercise5(listOf(5.0, 6.0, 7.0)))
                add(Exercise5(listOf(0.0, 0.0, 0.0)))
                add(Exercise5(listOf(1.0, 1.0, 1.0)))
                add(Exercise5(listOf(10.0, 10.0, 0.0)))
            }

            exercise5Test.answerList.apply {
                add(4.13)
                add(6.3)
                add(0.0)
                add(1.0)
                add(5.0)
            }
        }
    }
}