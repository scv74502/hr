package com.hr.api.repository

import com.hr.api.repository.custom.DepartmentCustomRepository
import com.hr.domain.entity.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository: JpaRepository<Department, Long>, DepartmentCustomRepository {
    fun findDepartmentById(id: Long): Department?
}