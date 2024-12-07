package com.hr.api.service

import com.core.exception.exceptions.DefaultException
import com.core.exception.exceptions.exceptionCode.DefaultExceptionCode
import com.core.log.logger
import com.hr.api.controller.response.DeptInfoResponse
import com.hr.api.controller.response.UpdateDeptSalaryResponse
import com.hr.api.repository.DepartmentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeptService(
    private val departmentRepository: DepartmentRepository,
) {
    @Transactional(readOnly = true)
    fun getDeptInfo(id:Long): DeptInfoResponse? {
        val result = departmentRepository.findDeptInfoById(id)
        result ?: run {
            logger.error { "[DeptService.getDeptInfo] Department with id $id is empty" }
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        return result
    }

    @Transactional
    fun raiseDeptSalary(id: Long, percentage: Double): List<UpdateDeptSalaryResponse> {
        val increasePercentage = percentage.div(100.0)
        val result = departmentRepository.raiseDeptSalary(id, increasePercentage)

        if(result.isEmpty()){
            logger.error { "[DeptService.raiseDeptSalary] Department with id $id has no employee" }
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        return result
    }
}