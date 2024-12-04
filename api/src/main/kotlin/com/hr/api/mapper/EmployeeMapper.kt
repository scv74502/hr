package com.hr.api.mapper

import com.hr.api.controller.response.EmployeeCurInfoResponse
import com.hr.domain.entity.Employee
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface EmployeeMapper {
    @Mapping(source = "manager.id", target = "managerId")
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "job.jobId", target = "jobId")
    @Mapping(target = "managerNow", expression = "java(employee.getManager() == null)")
    fun toEmployee(employee: Employee?): EmployeeCurInfoResponse
}