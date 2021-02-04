package dev.estudos.kotlin.exercicios.pessoas.util

/**
 * Throws an exception with a custom message
 */
fun fail(message: String): Nothing {
    throw(ExceptionInInitializerError("""FAILURE = $message"""))
}