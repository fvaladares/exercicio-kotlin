package dev.estudos.kotlin.exercicios.pessoas.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Pessoa(
    id: Int = 0,
    name: String = "None",
    sex: Sex = Sex.FEMALE,
    cpf: String = "0",
    rg: String = "0",
    birthday: LocalDate = LocalDate.parse("01/01/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
    height: BigDecimal = BigDecimal.ZERO,
    weight: BigDecimal = BigDecimal.ZERO,
    address: Address = Address("", "", "", "", ""),
    phone: String = "0"
) {
    fun calcIMC(): BigDecimal = BigDecimal.ZERO
}