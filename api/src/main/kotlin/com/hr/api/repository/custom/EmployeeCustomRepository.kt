package com.hr.api.repository.custom

import com.hr.api.controller.response.EmpCurInfoResponse
import com.hr.api.controller.response.EmpWorkHistoryTemp

interface EmployeeCustomRepository {
    fun findEmpById(id: Long): EmpCurInfoResponse?
    fun findEmpHistoryById(id: Long): MutableList<EmpWorkHistoryTemp>?
}