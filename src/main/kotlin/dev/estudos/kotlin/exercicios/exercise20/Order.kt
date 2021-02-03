package dev.estudos.kotlin.exercicios.exercise20


/**
 * This class represents an Order made by a client
 * It keep the products in a List
 * You can use the method add to add one Product
 * Or you ca use the method addAll to add several Products
 */
class Order(val orderNumber: Int) {
    private var products = mutableListOf<Product>()

    /**
     * @param newProduct
     * @return an updated Order
     */
    fun add(newProduct: Product): Order {
        products.add(newProduct)
        return this
    }

    /**
     * @param newProducts
     * @return an updated Order
     */
    fun addAll(newProducts: List<Product>): Order {
        products.addAll(newProducts)
        return this
    }

    /** The calculation is done with BigDecimal.
     * @param cod, amount
     * @return Double
     */
    @Throws(Throwable::class)
    fun finalPrice(cod: Int, amount: Int): Double {
        val test = products
            .filter { it.code == cod }
            .map { it.unitPrice }
            .reduceOrNull() { acc, d ->
                acc + d
            }

        if (test != null) {
            /**
             * Log for debug purpose
             */
            println(
                """
            Product returned    =   $test
            Amount              =   $amount
            Total               =   ${amount * test}
        """.trimIndent()
            )
            return ((test.toBigDecimal() * amount.toBigDecimal()).toDouble())
        } else {
            throw Throwable(
                "Invalid code",
                Throwable()
            )
        }
    }

    /** The calculation is done with BigDecimal.
     * @param cod, amount
     * @return Double
     */
    @Throws(Throwable::class)
    fun finalPrice(cod: String, amount: Int): Double {
        val test = products
            .filter { it.code == cod }
            .map { it.unitPrice }
            .reduceOrNull() { acc, d ->
                acc + d
            }

        if (test != null) {
            /**
             * Log for debug purpose
             */
            println(
                """
            Product returned    =   $test
            Amount              =   $amount
            Total               =   ${amount * test}
        """.trimIndent()
            )
            return ((test.toBigDecimal() * amount.toBigDecimal()).toDouble())
        } else {
            throw Throwable(
                "Invalid code",
                Throwable()
            )
        }
    }
}