package com.hr.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

@Entity
@Table(name = "jobs")
open class Job {
    @Id
    @Size(max = 10)
    @Column(name = "job_id", nullable = false, length = 10)
    open var jobId: String? = null

    @Size(max = 35)
    @NotNull
    @Column(name = "job_title", nullable = false, length = 35)
    open var jobTitle: String? = null

    @Column(name = "min_salary", precision = 8)
    open var minSalary: BigDecimal? = null

    @Column(name = "max_salary", precision = 8)
    open var maxSalary: BigDecimal? = null
}