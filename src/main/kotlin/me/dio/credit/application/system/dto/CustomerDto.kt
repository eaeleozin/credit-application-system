package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
       @field:NotEmpty(message = "This field can't be empty!") val firstName: String,
       @field:NotEmpty(message = "This field can't be empty!")val lastName: String,
       @field:NotEmpty(message = "This field can't be empty!")
       @CPF(message = "This CPF is not valid") val cpf: String,
       @field:NotNull (message = "This field can't be blank!")val income: BigDecimal,
       @field:Email(message = "Please, insert a valid e-mail")
       @field:NotEmpty(message = "This field can't be empty!")val email: String,
       @field:NotEmpty(message = "This field can't be empty!")val password: String,
       @field:NotEmpty(message = "This field can't be empty!")val zipCode: String,
       @field:NotEmpty(message = "This field can't be empty!")val street: String

) {

    fun toEntity(): Customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                    zipCode = this.zipCode,
                    street = this.street
            )
    )

}
