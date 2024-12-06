package com.hr.api.controller.response

import java.math.BigDecimal
import java.time.LocalDate

data class UpdateEmpResponse(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val phoneNumber: String?,
    val hireDate: LocalDate?,
    val jobId: String?,
    val salary: BigDecimal?,
    val commissionPct: BigDecimal?,
    val managerId: Long?,
    val departmentId: Long?,
    val managerNow: Boolean
)