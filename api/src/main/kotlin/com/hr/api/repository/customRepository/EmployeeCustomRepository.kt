package com.hr.api.repository.customRepository

import com.hr.api.controller.response.EmpWorkHistoryTemp

interface EmployeeCustomRepository {
    fun findEmpHistoryById(id: Long): MutableList<EmpWorkHistoryTemp>?
}