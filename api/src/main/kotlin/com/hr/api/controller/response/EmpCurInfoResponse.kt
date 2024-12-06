package com.hr.api.controller.response

import java.math.BigDecimal
import java.time.LocalDate

data class EmpCurInfoResponse(
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