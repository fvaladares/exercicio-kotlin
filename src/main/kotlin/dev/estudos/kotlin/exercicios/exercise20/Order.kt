package dev.estudos.kotlin.exercicios.exercise20

class Order(val orderNumber: Int) {
    private var products = mutableListOf<Product>()

    fun add(newProduct: Product): Order {
        products.add(newProduct)
        return this
    }

    fun addAll(newProducts: List<Product>): Order {
        products.addAll(newProducts)
        return this
    }

    fun finalPrice(cod: Int, amount: Int) {

    }
}