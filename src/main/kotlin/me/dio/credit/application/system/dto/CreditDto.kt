package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.Range
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        @field:NotNull(message = "Invalid input") val creditValue: BigDecimal,
        @field:Future val dayFirstOfInstallment: LocalDate,
        @field:Positive(message = " The number of Installment must be a positive number")
        @field:Range(min = 1, max = 12, message = "The number of installments must be between 1 and 12")
        val numberOfInstallments: Int,
        @field:NotNull(message = "Invalid input") val customerId: Long
) {

    fun toEntity(): Credit = Credit(
            creditValue = this.creditValue,
            dayFirstInstallment = this.dayFirstOfInstallment,
            numberOfInstallments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
    )

}
