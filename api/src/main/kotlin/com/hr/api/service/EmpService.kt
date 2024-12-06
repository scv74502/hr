package com.hr.api.service

import com.core.exception.exceptions.DefaultException
import com.core.exception.exceptions.exceptionCode.DefaultExceptionCode
import com.core.log.logger
import com.hr.api.controller.request.UpdateEmpRequest
import com.hr.api.controller.response.EmpCurInfoResponse
import com.hr.api.controller.response.EmpHistoryResponse
import com.hr.api.controller.response.UpdateEmpResponse
import com.hr.api.controller.response.EmpWorkHistoryResponse
import com.hr.api.repository.DepartmentRepository
import com.hr.api.repository.EmployeeRepository
import com.hr.api.repository.JobRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@RequiredArgsConstructor
class EmpService (
    private val employeeRepository: EmployeeRepository,
    private val jobRepository: JobRepository,
    private val departmentRepository: DepartmentRepository,
){
    @Transactional(readOnly = true)
    fun getEmpCurInfo(id: Long): EmpCurInfoResponse? {
        return employeeRepository.findEmpById(id) ?: run {
            logger.error { "[EmpService.getEmpCurInfo] Employee not found with id: $id" }
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }
    }

    @Transactional(readOnly = true)
    fun getEmpHistory(id: Long): EmpHistoryResponse? {
        val empHistory = employeeRepository.findEmpHistoryById(id) ?: run{
            logger.error("[EmpService.getEmpCurInfo] EmpHistory with id $id is null")
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        if (empHistory.isEmpty()) {
            logger.error("[EmpService.getEmpCurInfo] EmpHistory with id $id is empty")
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        return EmpHistoryResponse(
            empHistory[0].empName ?: "UNKNOWN",
            workRecord = empHistory.map {
                EmpWorkHistoryResponse(
                    startDate = it.startDate,
                    endDate = it.endDate,
                    jobTitle = it.jobTitle,
                    deptName = it.deptName
                )
            }
        )
    }

    @Transactional
    fun updateEmpInfo(id: Long, empUpdateRequest: UpdateEmpRequest): UpdateEmpResponse? {
        val employee = employeeRepository.findEmployeeById(id) ?: run {
            logger.error("[EmpService.updateEmpInfo] Employee with id: $id is null")
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        empUpdateRequest.firstName?.let { employee.firstName = it }
        empUpdateRequest.lastName?.let { employee.lastName = it }
        empUpdateRequest.email?.let { employee.email = it }
        empUpdateRequest.phoneNumber?.let { employee.phoneNumber = it }
        empUpdateRequest.hireDate?.let { employee.hireDate = it }
        empUpdateRequest.salary?.let { employee.salary = it }
        empUpdateRequest.commissionPct?.let { employee.commissionPct = it }

        empUpdateRequest.jobId?.let { jobId ->
            val job = jobRepository.findJobByJobId(jobId)
            job?.let{
                employee.job = job
            }
        }

        // managerId가 null이면 employee.manager는 자동으로 null
        employee.manager = empUpdateRequest.managerId?.let { managerId ->
            employeeRepository.findEmployeeById(managerId)
        }

        empUpdateRequest.departmentId?.let { departmentId ->
            val department = departmentRepository.findDepartmentById(departmentId)
            department?.let{
                employee.department = department
            }
        }

        val result = employeeRepository.save(employee)
        // managerNow 설정 로직
        val managerNow = result.manager?.id == null

        return UpdateEmpResponse(
            firstName = result.firstName,
            lastName = result.lastName,
            email = result.email,
            phoneNumber = result.phoneNumber,
            hireDate = result.hireDate,
            jobId = result.job?.jobId,
            salary = result.salary,
            commissionPct = result.commissionPct,
            managerId = result.manager?.id,
            managerNow = managerNow,
            departmentId = result.department?.id
        )
    }
}