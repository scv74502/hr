package com.hr.api.repository

import com.hr.domain.entity.Employee
import com.querydsl.core.QueryFactory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface EmployeeRepository: JpaRepository<Employee, Long>, EmployeeCustomRepository {

}