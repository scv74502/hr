package com.hr.api.controller

import com.core.log.logger
import com.hr.api.controller.request.UpdateDeptSalaryRequest
import com.hr.api.controller.response.DeptInfoResponse
import com.hr.api.service.DeptService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dept")
class DeptController(
    val deptService: DeptService
) {
    @GetMapping("/{id}")
    fun getDeptInfo(@PathVariable id:Long):ResponseEntity<DeptInfoResponse>{
        logger.info{ "[DeptController.getDeptInfo] id : $id" }
        val result = deptService.getDeptInfo(id)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @PostMapping("/salary-raise/{id}")
    fun raiseDeptSalary(
        @PathVariable id:Long,
        @RequestBody updateDeptSalaryRequest: UpdateDeptSalaryRequest
    ):ResponseEntity<String>{
        logger.info{ "[DeptController.raiseDeptSalary] id : $id, percentage : ${updateDeptSalaryRequest.percentage}%" }
//        val result = deptService.
        return ResponseEntity("""""", HttpStatus.OK)
    }
}