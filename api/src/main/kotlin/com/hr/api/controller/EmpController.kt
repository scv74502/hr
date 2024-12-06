package com.hr.api.controller

import com.core.exception.exceptions.DefaultException
import com.core.exception.exceptions.exceptionCode.DefaultExceptionCode
import com.core.log.logger
import com.hr.api.controller.response.EmpCurInfoResponse
import com.hr.api.controller.response.EmpHistoryResponse
import com.hr.api.controller.request.UpdateEmpRequest
import com.hr.api.controller.response.UpdateEmpResponse
import com.hr.api.service.EmpService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/emp")
class EmpController(
    val empService: EmpService
) {
    @GetMapping("/cur-info/{id}")
    fun getCurInfo(@PathVariable id: Long): ResponseEntity<EmpCurInfoResponse> {
        logger.info{ "[EmpController.getCurInfo] id : $id" }
        val employeeCurInfoResponse = empService.getEmpCurInfo(id)
        val result: ResponseEntity<EmpCurInfoResponse> = ResponseEntity.ok(employeeCurInfoResponse)
        return result
    }

    @GetMapping("/history/{id}")
    fun getEmpHistory(@PathVariable id: Long): ResponseEntity<EmpHistoryResponse> {
        logger.info{ "[EmpController.getEmpHistory] id : $id" }
        val empHistoryResponse = empService.getEmpHistory(id)
        if (empHistoryResponse == null) {
            logger.error { "[EmpController.getEmpHistory] EmpHistory with id $id not found" }
            throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
        }
        val result: ResponseEntity<EmpHistoryResponse> = ResponseEntity.ok(empHistoryResponse)
        return result
    }

    @GetMapping("/exception")
    fun throwException(): String {
        throw DefaultException(DefaultExceptionCode.RESOURCE_NOT_FOUND)
    }

    @PatchMapping("/{id}")
    fun patchEmpInfo(@PathVariable id:Long,@RequestBody empUpdateRequest: UpdateEmpRequest): ResponseEntity<UpdateEmpResponse>{
        val result = empService.updateEmpInfo(id, empUpdateRequest)
        return ResponseEntity.ok(result)
    }
}