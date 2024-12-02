package com.hr.api.repository

import com.hr.domain.entity.Employee
import com.hr.domain.repository.EmployeeDomainRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

public interface EmployeeRepository:EmployeeDomainRepository{
    fun findEmployeeById(id: Long): Employee?
}