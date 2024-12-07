package com.hr.api.repository.custom

import com.hr.api.controller.response.DeptInfoResponse
import com.hr.api.controller.response.UpdateDeptSalaryResponse

interface DepartmentCustomRepository {
    fun findDeptInfoById(id: Long): DeptInfoResponse?
    fun raiseDeptSalary(id: Long, increasePercentage: Double): List<UpdateDeptSalaryResponse>
}