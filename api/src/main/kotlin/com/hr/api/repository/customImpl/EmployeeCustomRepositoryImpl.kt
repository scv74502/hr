package com.hr.api.repository.customImpl

import com.hr.api.controller.response.EmpCurInfoResponse
import com.hr.api.controller.response.EmpWorkHistoryTemp
import com.hr.api.repository.custom.EmployeeCustomRepository
import com.hr.domain.entity.*
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.DatePath
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class EmployeeCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): EmployeeCustomRepository {
    val employee = QEmployee.employee
    val jobHistory = QJobHistory.jobHistory
    val jobHistoryId = QJobHistoryId.jobHistoryId
    val job = QJob.job
    val department = QDepartment.department
    val manager = QEmployee.employee

    override fun findEmpById(id: Long): EmpCurInfoResponse? {
        return queryFactory
            .select(
                Projections.bean(
                    EmpCurInfoResponse::class.java,
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
            .orderBy(getOrderSpecifierByDateAsc(jobHistory.id.startDate), getOrderSpecifierByDateAsc(jobHistory.endDate))
            .fetch()

        return results
    }

    fun getOrderSpecifierByDateAsc(datePath: DatePath<LocalDate>): OrderSpecifier<LocalDate>{
        return OrderSpecifier(Order.ASC, datePath)
    }

    fun getOrderSpecifierByDateDesc(datePath: DatePath<LocalDate>): OrderSpecifier<LocalDate>{
        return OrderSpecifier(Order.DESC, datePath)
    }
}

