package com.hr.domain.repository

import com.hr.domain.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

public interface EmployeeDomainRepository: JpaRepository<Employee, Long> {
}