package com.hr.api.controller.response

import com.hr.domain.entity.Employee
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
){
    companion object {
        fun of(employee:Employee): UpdateEmpResponse {
            return UpdateEmpResponse(
                firstName = employee.firstName,
                lastName = employee.lastName,
                email = employee.email,
                phoneNumber = employee.phoneNumber,
                hireDate = employee.hireDate,
                jobId = employee.job?.jobId,
                salary = employee.salary,
                commissionPct = employee.commissionPct,
                managerId = employee.manager?.id,
                managerNow = employee.manager == null,
                departmentId = employee.department?.id
            )
        }
    }
}