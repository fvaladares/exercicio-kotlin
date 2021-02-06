package com.android.developer.codelab


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val message = """
        List: $numbers
        Size: ${numbers.size}""".trimIndent()

    println(message)

    val total = numbers.sumBy {
        it
    }

    println("Total: $total")
}

class ListsTest