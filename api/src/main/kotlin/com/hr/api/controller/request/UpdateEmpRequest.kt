package com.hr.api.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDate

data class UpdateEmpRequest(
    @Size(min = 1, max = 50)
    val firstName: String?,
    @Size(min = 1, max = 50)
    val lastName: String?,
    @Email
    val email: String?,
    @Size(min = 1, max = 50)
    val phoneNumber: String?,
    val hireDate: LocalDate?,
    @Size(min = 1, max = 10)
    val jobId: String?,
    @Min(0)
    val salary: BigDecimal?,
    @Min(0L)
    val commissionPct: BigDecimal?,
    val managerId: Long?,
    val departmentId: Long?
)
