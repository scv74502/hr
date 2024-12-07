package com.hr.api.repository.custom

import com.hr.api.controller.response.DeptInfoResponse

interface DepartmentCustomRepository {
    fun findDeptInfoById(id: Long): DeptInfoResponse?
}