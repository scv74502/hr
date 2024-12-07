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
        val result = employeeRepository.findEmpById(id)
        result ?: run {
            logger.error { "[EmpService.getEmpCurInfo1] Employee with id $id is empty" }
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        return result
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
        val employee = employeeRepository.findEmployeeWithJobAndDepartment(id) ?: run {
            logger.error("[EmpService.updateEmpInfo] Employee with id: $id is null")
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }

        empUpdateRequest.apply {
            firstName?.let { employee.firstName = it }
            lastName?.let { employee.lastName = it }
            email?.let { employee.email = it }
            phoneNumber?.let { employee.phoneNumber = it }
            hireDate?.let { employee.hireDate = it }
            salary?.let { employee.salary = it }
            commissionPct?.let { employee.commissionPct = it }

            jobId?.let { it ->
                employee.job = jobRepository.findJobByJobId(it) ?: let{
                    logger.error("[EmpService.updateEmpInfo] jobs with jobId: '${it.jobId}' is not found")
                    throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
                }
            } ?: let {
                employee.job = null
            }

            managerId?.let { it ->
                employee.manager = employeeRepository.findEmployeeById(it) ?: let{
                    logger.error("[EmpService.updateEmpInfo] manager with id: '${it.managerId}' is not found")
                    throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
                }
            } ?: let {
                employee.manager = null
            }

            departmentId?.let { it ->
                employee.department = departmentRepository.findDepartmentById(it) ?: let{
                    logger.error("[EmpService.updateEmpInfo] department with id: '${it.departmentId}' is not found")
                    throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
                }
            } ?: let {
                employee.department = null
            }
        }

        val updatedEmployee = employeeRepository.save(employee)
        return UpdateEmpResponse.of(updatedEmployee)
    }
}