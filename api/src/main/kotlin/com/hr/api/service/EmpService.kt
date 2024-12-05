package com.hr.api.service

import com.hr.api.mapper.EmployeeMapper
import com.hr.api.controller.response.EmployeeCurInfoResponse
import com.hr.api.repository.EmployeeCustomRepository
import com.hr.api.repository.EmployeeRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@RequiredArgsConstructor
class EmpService (
    private val employeeRepository: EmployeeRepository,
    private val mapper: EmployeeMapper
){
    @Transactional(readOnly = true)
    fun getEmpCurInfo(id: Long): EmployeeCurInfoResponse? {
        val employeeCurInfoResponse = employeeRepository.findEmpById(id)
        return employeeCurInfoResponse
    }
}