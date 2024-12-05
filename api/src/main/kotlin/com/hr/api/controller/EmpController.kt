package com.hr.api.controller

import com.core.exception.exceptions.DefaultException
import com.core.exception.exceptions.exceptionCode.DefaultExceptionCode
import com.core.log.logger
import com.hr.api.controller.response.EmployeeCurInfoResponse
import com.hr.api.service.EmpService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/emp")
class EmpController(
    val empService: EmpService
) {
    @GetMapping("/cur-info/{id}")
    fun getCurInfo(@PathVariable id: Long): ResponseEntity<EmployeeCurInfoResponse> {
        logger.info{ "[EmpController.getCurInfo] id : $id" }
        val employeeCurInfoResponse = empService.getEmpCurInfo(id)
        if (employeeCurInfoResponse == null){
            logger.error { "[EmpController.getCurInfo] Emp with id ${id} not found" }
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }
        val result: ResponseEntity<EmployeeCurInfoResponse> = ResponseEntity.ok(employeeCurInfoResponse)
        return result
    }

    @GetMapping("/exception")
    fun throwException(): String {
        throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
    }
}