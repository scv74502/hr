package com.hr.api.controller.response

import java.time.LocalDate

data class EmpHistoryResponse(
    var empName:String?,
    var workRecord: List<EmpWorkHistoryResponse>? = listOf()
)
