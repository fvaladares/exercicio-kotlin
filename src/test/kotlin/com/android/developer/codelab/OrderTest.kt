package com.android.developer.codelab

import org.junit.jupiter.api.Test

internal class OrderTest {

    @Test
    fun addItem() {
        val order = Order(1)
        order.addItem(Vegetables("Cabbage, Carrot, Potato, Onion"))

    }

    @Test
    fun addAll() {
    }

    @Test
    fun getOrderNumber() {
    }
}