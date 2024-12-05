package com.hr.api.controller.response

import com.hr.domain.entity.Employee
import com.hr.domain.entity.Job
import org.mapstruct.factory.Mappers
import java.math.BigDecimal
import java.time.LocalDate

data class EmployeeCurInfoResponse(
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var hireDate: LocalDate? = null,
    var jobId: String? = null,
    var salary: BigDecimal? = null,
    var commissionPct: BigDecimal? = null,
    var managerId: Long? = null,
    var departmentId: Long? = null,
    var managerNow: Boolean? = false
)