package dev.estudos.kotlin.exercicios.exercise20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OrderTest {
    private lateinit var order: Order
    private lateinit var order2: Order

    @Test
    fun add() {
        val product = Product(1001, 2.50)
        val order = Order(1)
        assertTrue(order.add(product) === order)
    }

    @Test
    fun addAll() {
        val product = Product(1001, 2.50)
        this.order = Order(1)

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

    @ParameterizedTest
    @CsvSource(
        "1001,  1,      5.32",
        "1324,  10,     64.50",
        "6548,  3,      7.11",
        "987,   8,      42.56",
        "7623,  10,     64.50",
        "1111,  1,      5.32",
    )
    fun finalPrice(cod: Int, amount: Int, expected: Double) {
        try {
            val finalPrice = order.finalPrice(cod, amount)
            assertEquals(expected, finalPrice)
        } catch (e: IllegalArgumentException) {
            println("Invalid code informed.")
        }
    }

    @ParameterizedTest
    @CsvSource(
        "ABCD,  1,      5.30",
        "XYPK,  10,     60.00",
        "KLMP,  20,     64.00",
        "QRST,  30,     75.00",
        "12345,  30,     75.00"
    )
    fun finalPrice(cod: String, amount: Int, expected: Double) {
        try {
            val finalPrice = order.finalPrice(cod, amount)
            assertEquals(expected, finalPrice)
        } catch (e: IllegalArgumentException) {
            println("Invalid code informed.")
        }
    }

    // Create an object with the values gave by US.
    @BeforeEach
    fun init() {
        println("Starting tests...")
        order = Order(1)
        val products = listOf(
            Product(1001, 5.32),
            Product(1324, 6.45),
            Product(6548, 2.37),
            Product(987, 5.32),
            Product(7623, 6.45),
            Product("ABCD", 5.30),
            Product("XYPK", 6.00),
            Product("KLMP", 3.20),
            Product("QRST", 2.50)
        )
        order.addAll(products)
    }
}