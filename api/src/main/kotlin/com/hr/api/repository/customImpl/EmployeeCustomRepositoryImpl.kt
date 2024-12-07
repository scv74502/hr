package com.hr.api.repository.customImpl

import com.hr.api.controller.response.EmpCurInfoResponse
import com.hr.api.controller.response.EmpWorkHistoryTemp
import com.hr.api.repository.custom.EmployeeCustomRepository
import com.hr.domain.entity.*
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class EmployeeCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): EmployeeCustomRepository {
    val employee = QEmployee.employee
    val jobHistory = QJobHistory.jobHistory
    val job = QJob.job
    val department = QDepartment.department
    val managerAlias = QEmployee("managerAlias")

    override fun findEmpById(id: Long): EmpCurInfoResponse? {
        return queryFactory
            .select(
                Projections.bean(
                    EmpCurInfoResponse::class.java,
                    employee.firstName,
                    employee.lastName,
                    employee.email,
                    employee.phoneNumber,
                    employee.hireDate,
                    employee.job.jobId.`as`("jobId"),
                    employee.salary,
                    employee.commissionPct,
                    employee.manager.id.`as`("managerId"),
                    employee.department.id.`as`("departmentId"),
                    managerAlias.isNull.`as`("managerNow")
                )
            )
            .from(employee)
            .leftJoin(employee.job, job)
            .leftJoin(employee.department, department)
            .leftJoin(employee.manager, managerAlias)
            .where(employee.id.eq(id))
            .fetchOne()
    }

    override fun findEmpHistoryById(id: Long): MutableList<EmpWorkHistoryTemp>? {
        val results = queryFactory
        .select(
            Projections.constructor(
                EmpWorkHistoryTemp::class.java,
                employee.lastName.concat(" ").concat(employee.firstName). `as` ("empName"),
                jobHistory.id.startDate,
                jobHistory.endDate,
                job.jobTitle,
                department.departmentName
            )
        )
            .from(jobHistory)
            .join(jobHistory.employee, employee) // 복합 키를 통한 조인
            .join(jobHistory.job, job)
            .join(jobHistory.department, department)
            .where(jobHistory.employee.id.eq(id))
            .orderBy(jobHistory.id.startDate.asc(), jobHistory.endDate.asc())
            .fetch()

        return results
    }
}

