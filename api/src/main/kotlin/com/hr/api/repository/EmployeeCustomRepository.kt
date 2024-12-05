package com.hr.api.repository

import com.hr.api.controller.response.EmployeeCurInfoResponse
import org.springframework.stereotype.Repository

interface EmployeeCustomRepository {
    fun findEmpById(id: Long): EmployeeCurInfoResponse?
}