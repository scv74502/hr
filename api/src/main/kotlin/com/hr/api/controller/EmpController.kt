package com.hr.api.controller

import com.hr.api.controller.response.EmployeeCurInfoResponse
import com.hr.api.service.EmpService
import com.hr.domain.entity.Employee
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
        val employeeCurInfo = empService.getCurInfo(id)
        if (employeeCurInfo.id == null) {
            return ResponseEntity.notFound().build()
        }
        val result: ResponseEntity<EmployeeCurInfoResponse> = ResponseEntity.ok(employeeCurInfo)
        return result
    }
}