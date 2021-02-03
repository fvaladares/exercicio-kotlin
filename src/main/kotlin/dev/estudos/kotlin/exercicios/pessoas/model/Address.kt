package dev.estudos.kotlin.exercicios.pessoas.model

data class Address(
    val street: String,
    val number: String,
    val neighborhood: String,
    val city: String,
    val uf: String
)