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

                throw (IllegalStateException(msg.format("Height and Weight", "those fields")))
            }
            checkHeight -> {

                throw (IllegalStateException(msg.format("Height", "this field")))
            }
            checkWeight -> {

                throw (IllegalStateException(msg.format("Weight", "this field")))
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

        /**
         * Creates a new People object and returns a self-reference
         * Validations: CPF (isNumber and size == 11)
         * Data: This field receives a String with the format: dd/MM/yyyy
         */
        @Throws(ExceptionInInitializerError::class)
        fun create(
            name: String,
            birthday: String,
            phone: String,
            cpf: String,
            rg: String,
            sex: Sex = Sex.UNDEFINED,
            height: BigDecimal = BigDecimal.ZERO,
            weight: BigDecimal = BigDecimal.ZERO,
            address: Address,
        ): Pessoa {


            when {
                cpf.toIntOrNull() == null ->
                    throw ExceptionInInitializerError("..| The CPF field only receives numbers (11) |..")


                cpf.length != 11 ->
                    throw ExceptionInInitializerError("..| The CPF field needs to be 11 numbers long. |..")


                else -> {
                    val p = Pessoa(
                        id = id,
                        name = name,
                        birthday = LocalDate.parse(
                            birthday,
                            DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        ),
                        phone = phone,
                        cpf = cpf,
                        rg = rg,
                        sex = sex,
                        height = height,
                        weight = weight,
                        address = address,
                    )
                    id++

                    return p
                }
            }
        }
    }
}