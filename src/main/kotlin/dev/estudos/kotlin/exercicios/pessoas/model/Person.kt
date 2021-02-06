package dev.estudos.kotlin.exercicios.pessoas.model

import dev.estudos.kotlin.exercicios.pessoas.util.fail
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter


data class Person constructor(
    var id: Int = 0,
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


    @Throws(UninitializedPropertyAccessException::class)
    fun calcIMC(): BigDecimal {
        val checkWeight = weight.compareTo(BigDecimal.ZERO) == 0
        val checkHeight = height.compareTo(BigDecimal.ZERO) == 0
        val msg = """
            
                %s can't be ZERO, please, update %s.
                
                """.trimIndent()

        when {
            checkHeight && checkWeight ->
                throw (UninitializedPropertyAccessException(msg.format("Height and Weight", "those fields")))

            checkHeight ->
                throw (UninitializedPropertyAccessException(msg.format("Height", "this field")))

            checkWeight ->
                throw (UninitializedPropertyAccessException(msg.format("Weight", "this field")))
        }

        return (weight / (height.pow(2)))
    }

    companion object {

        private var id = 0

        private fun validateRG(sentence: String): Boolean {
            var count = 0

            sentence.forEach {
                if (it in '0'..'9') count++
            }

            return when {
                count >= 6 -> true
                else -> false
            }
        }

        private fun phoneValidator(phoneNumber: String): Boolean {
            val purePhoneNumber = phoneNumber.replace('.', ' ')
                .replace('-', ' ').filter { !it.isWhitespace() }
            return when {
                purePhoneNumber.toLongOrNull() == null -> false
                purePhoneNumber.length < 10 || purePhoneNumber.length > 11 -> false
                else -> true
            }
        }

        private fun nameValidator(name: String): Boolean {
            val partsOfName = name.split(" ")

            return when {
                partsOfName.size < 2 ->
                    false // At least two words

                partsOfName.size < 2 ->
                    false // At least one word with more the 2 characters

                partsOfName.first().length > 1 && partsOfName.size >= 2 && partsOfName.last().length > 1 ->
                    return true // Accept one letter if the name has more then 2 words

                else -> false
            }
        }


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
        ): Person {
            when {
                cpf.length != 11 ->
                    fail("..| The CPF field needs to be 11 numbers long. |..")

                cpf.trim().toLongOrNull() == null ->
                    fail("..| The CPF field only receives numbers (11) *** Data informed: $cpf *** |..")

                !validateRG(rg) ->
                    fail("..| The RG field needs at least 6 numbers |..")

                !phoneValidator(phone) ->
                    fail("""=== 
                        
                        ..|The phone number must have 10 or 11 digits. 31 1234-5678 or 31 91234-5678 |..
                        
                        Informed number: $phone
                        
                        ===
                        """.trimMargin())

                !nameValidator(name) ->
                    fail(
                        """
                            ===
                            
                            ..| The informed name is invalid. It should have Name and a Surname |..
                            
                            Name informed: $name
                            
                            ===
                        """.trimMargin()
                    )

                else -> {
                    val p = Person(
                        id = id,
                        name = name.split(" ").asSequence().map { it.capitalize() }.joinToString(" "),
                        birthday = LocalDate.parse(
                            birthday,
                            DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        ),
                        phone = phone.replace('.', ' ')
                            .replace('-', ' ')
                            .trim(),
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