package dev.estudos.kotlin.exercicios.calculadora

object Calc {

    /**
     * This method receives three parameters: x: Double, y: Double, Lambda and returns a Double
     */
    fun operation(
        x: Double,
        y: Double,
        customFunction: (inputA: Double, inputB: Double) -> Double,
    ): Double =
        customFunction(x, y)
}