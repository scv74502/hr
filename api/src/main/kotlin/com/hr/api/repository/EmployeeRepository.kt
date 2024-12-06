package com.hr.api.repository

import com.hr.api.repository.custom.EmployeeCustomRepository
import com.hr.domain.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<Employee, Long>, EmployeeCustomRepository {
    fun findEmployeeById(id: Long): Employee?
}