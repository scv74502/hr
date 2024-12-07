package com.hr.api.controller.request

import jakarta.validation.constraints.Size

data class UpdateDeptSalaryRequest(
    @Size(min = 1)
    val percentage: Long?
)
