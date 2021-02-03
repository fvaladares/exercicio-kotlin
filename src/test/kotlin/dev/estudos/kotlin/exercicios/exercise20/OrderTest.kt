package dev.estudos.kotlin.exercicios.exercise20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class OrderTest {

    @Test
    fun add() {
        val product = Product(1001, 2.50)
        val order = Order(1)


        assertTrue(order.add(product) === order)

//        val p1: Product = product.copy()
//
//        if (product == p1) {
//            println("Test passed ${product.code}")
//            println("""
//                Product:
//                   code: ${product.code}
//                   price $${product.unitPrice}
//            """.trimIndent())
//
//            println("""
//                P1:
//                   code: ${p1.code}
//                   price $${p1.unitPrice}
//            """.trimIndent())
//
//        } else {
//            println("Test Failed")
//        }
    }

    @Test
    fun addAll() {
        val product = Product(1001, 2.50)
        val order = Order(1)

        with(order) {
            addAll(
                listOf(
                    Product(1001, 2.5),
                    Product(1002, 3.0),
                    Product(1003, 450.0)
                )
            )
        }

        assertTrue(order.add(product) === order)
    }

    @Test
    fun getOrderNumber() {
        val orderNumber = 101
        assertEquals(orderNumber, Order(orderNumber).orderNumber)
    }
}