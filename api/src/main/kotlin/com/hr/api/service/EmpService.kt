package com.hr.api.service

import com.hr.api.repository.EmployeeRepository
import com.hr.domain.repository.EmployeeDomainRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@RequiredArgsConstructor
class EmpService (
    private val employeeRepository: EmployeeRepository,
){
    @Transactional(readOnly = true)
    fun getCurInfo(id: Long): Any {
        return employeeRepository.findById(id)
    }
}