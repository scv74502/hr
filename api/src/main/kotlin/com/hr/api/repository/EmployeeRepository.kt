package com.hr.api.repository

import com.hr.api.repository.custom.EmployeeCustomRepository
import com.hr.domain.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface EmployeeRepository: JpaRepository<Employee, Long>, EmployeeCustomRepository {
    fun findEmployeeById(id: Long): Employee?
    @Query("""
    SELECT e 
    FROM Employee e
    LEFT JOIN FETCH e.job j
    LEFT JOIN FETCH e.department d
    LEFT JOIN FETCH e.manager 
    WHERE e.id = :id
""")
    fun findEmployeeWithJobAndDepartment(id: Long): Employee?
}