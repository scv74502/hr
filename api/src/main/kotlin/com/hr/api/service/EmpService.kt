package com.hr.api.service

import com.hr.api.mapper.EmployeeMapper
import com.hr.api.repository.EmployeeRepository
import com.hr.api.controller.response.EmployeeCurInfoResponse
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@RequiredArgsConstructor
class EmpService (
    private val employeeRepository: EmployeeRepository,
    private val mapper: EmployeeMapper
){
    @Transactional(readOnly = true)
    fun getCurInfo(id: Long): EmployeeCurInfoResponse {
        val employee =  employeeRepository.findEmployeeById(id)
        val result = mapper.toEmployee(employee)
        return result
    }
}