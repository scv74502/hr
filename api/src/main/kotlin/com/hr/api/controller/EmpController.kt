package com.hr.api.controller

import com.hr.api.service.EmpService
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
    fun getCurInfo(@PathVariable id: Long): Any {
        return empService.getCurInfo(id)
    }
}