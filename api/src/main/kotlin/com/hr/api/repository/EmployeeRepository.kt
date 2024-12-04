package com.hr.api.repository

import com.hr.domain.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: JpaRepository<Employee, Long> {
    fun findEmployeeById(id: Long): Employee?
}