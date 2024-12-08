package com.hr.api.controller.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Positive

data class MinWageSearchRequest(
    @Positive
    @Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다.")
    val page:Int,

    @Positive
    @Min(value = 1, message = "페이지당 자료 수는 1 이상이어야 합니다.")
    val perPage:Int,
)
