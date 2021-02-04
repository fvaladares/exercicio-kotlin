package dev.estudos.kotlin.exercicios.pessoas.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class Pessoa private constructor(
    private var id: Int = 0,
    var name: String,
    var birthday: LocalDate,
    var phone: String,
    var sex: Sex = Sex.UNDEFINED,
    var cpf: String,
    var rg: String,
    var height: BigDecimal = BigDecimal.ZERO,
    var weight: BigDecimal = BigDecimal.ZERO,
    var address: Address,
) {


    @Throws(IllegalArgumentException::class)
    fun calcIMC(): BigDecimal {
        val checkWeight = weight.compareTo(BigDecimal.ZERO) == 0
        val checkHeight = height.compareTo(BigDecimal.ZERO) == 0
        var msg = """%s can't be ZERO, please, update %s.""";


        when {
            checkHeight && checkWeight -> {
                msg.format("Height and Weight", "those fields")
                throw (IllegalStateException(msg))
            }
            checkHeight -> {
                msg.format("Height", "this field")
                throw (IllegalStateException(msg))
            }
            checkWeight -> {
                msg.format("Weight", "this field")
                throw (IllegalStateException(msg))
            }
        }


        return (weight / (height.pow(2)))
    }

    override fun toString(): String {
        return """
            Pessoa (id=$id, name=$name, cpf=$cpf, rg=$rg, birthday=$birthday, phone=$phone, $address) 
        """.trimIndent()
    }

    companion object Factory {

        var id = 0

        fun create(
            name: String,
            birthday: String,
            phone: String,
            cpf: String,
            rg: String,
            address: Address,
        ): Pessoa {
            val p = Pessoa(
                id = id,
                name = name,
                birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                phone = phone,
                cpf = cpf,
                rg = rg,
                address = address
            )
            id++

            return p
        }
    }
}