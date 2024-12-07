package com.hr.api.controller.request

import jakarta.validation.constraints.Positive

data class UpdateDeptSalaryRequest(
    @Positive
    val percentage: Double
)
