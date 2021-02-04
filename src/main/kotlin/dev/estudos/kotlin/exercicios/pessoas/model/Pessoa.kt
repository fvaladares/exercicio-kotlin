package dev.estudos.kotlin.exercicios.pessoas.model

import java.math.BigDecimal
import java.time.LocalDate


class Pessoa() {

    private var id: Int = 0
    lateinit var name: String
    lateinit var birthday: LocalDate
    lateinit var phone: String
    lateinit var sex: Sex
    lateinit var cpf: String
    lateinit var rg: String
    lateinit var height: BigDecimal
    lateinit var weight: BigDecimal
    lateinit var address: Address

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

    companion object {

//        var id = 0
//        fun createPessoa(name: String, birthday: LocalDate, phone: String, cpf: String, rg: String): Pessoa {
//            return Pessoa(name = name, birthday = birthday, phone = phone, cpf = cpf, rg = rg)
//        }
    }
}