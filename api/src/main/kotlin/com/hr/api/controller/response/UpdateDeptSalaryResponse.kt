package com.hr.api.controller.response

import java.math.BigDecimal

data class UpdateDeptSalaryResponse(
    val departmentName: String?,
    val employeeName: String?,
    val originalSalary: BigDecimal?,
    val increasedSalary: BigDecimal?
)
