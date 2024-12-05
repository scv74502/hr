package com.hr.api.repository.impl

import com.hr.api.controller.response.EmployeeCurInfoResponse
import com.hr.api.repository.EmployeeCustomRepository
import com.hr.api.repository.EmployeeRepository
import com.hr.domain.entity.QEmployee
import com.hr.domain.entity.QJob
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class EmployeeCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): EmployeeCustomRepository {
    val employee = QEmployee.employee
    val job = QJob.job
    val manager = QEmployee.employee

    override fun findEmpById(id: Long): EmployeeCurInfoResponse? {
        return queryFactory
            .select(
                Projections.bean(
                    EmployeeCurInfoResponse::class.java,
                    employee.id,
                    employee.firstName,
                    employee.lastName,
                    employee.email,
                    employee.phoneNumber,
                    employee.hireDate,
                    job.jobId.`as`("jobId"),
                    employee.salary,
                    employee.commissionPct,
                    employee.manager.id.`as`("managerId"),
                    employee.department.id.`as`("departmentId"),
                    employee.manager.isNull.`as`("managerNow")
                )
            )
            .from(employee)
            .where(employee.id.eq(id))
            .fetchOne()
    }
}