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
    JOIN FETCH e.job j
    JOIN FETCH e.department d
    WHERE e.id = :id
""")
    fun findEmployeeWithJobAndDepartment(id: Long): Employee?
}