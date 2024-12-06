package com.hr.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

@Entity
@Table(name = "job_history")
open class JobHistory {
    @EmbeddedId
    open var id: JobHistoryId? = null

    @NotNull
    @Column(name = "end_date", nullable = false)
    open var endDate: LocalDate? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    open var job: Job? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    open var department: Department? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false) // 복합 키와 연관
    open var employee: Employee? = null
}