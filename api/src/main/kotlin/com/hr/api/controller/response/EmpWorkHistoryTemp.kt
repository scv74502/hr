package com.hr.api.controller.response

import java.time.LocalDate

data class EmpWorkHistoryTemp(
    val empName: String?,
    val startDate:LocalDate,
    val endDate:LocalDate,
    val jobTitle:String,
    val deptName:String
) {
    constructor() : this("", LocalDate.now(), LocalDate.now(), "", "")
}

data class EmpWorkHistoryResponse(
    val startDate:LocalDate,
    val endDate:LocalDate,
    val jobTitle:String,
    val deptName:String
) {
    constructor() : this(LocalDate.now(), LocalDate.now(), "", "")
}
