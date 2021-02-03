package dev.estudos.kotlin.exercicios.exercise20

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProductTest {
    @Test
    fun getPrice() {
        val product = Product(code = 1001, unitPrice = 1.50)
        assertAll(
            "Product Test (Code and price)",
            { assertEquals(1001, product.code) },
            { assertEquals(1.5, product.unitPrice) }
        )
    }


}