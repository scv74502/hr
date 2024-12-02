package com.hr.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "employees")
open class Employee {
    @Id
    @Column(name = "employee_id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Size(max = 20)
    @Column(name = "first_name", length = 20)
    open var firstName: String? = null

    @Size(max = 25)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 25)
    open var lastName: String? = null

    @Size(max = 25)
    @NotNull
    @Column(name = "email", nullable = false, length = 25)
    open var email: String? = null

    @Size(max = 20)
    @Column(name = "phone_number", length = 20)
    open var phoneNumber: String? = null

    @NotNull
    @Column(name = "hire_date", nullable = false)
    open var hireDate: LocalDate? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    open var job: Job? = null

    @NotNull
    @Column(name = "salary", nullable = false, precision = 8, scale = 2)
    open var salary: BigDecimal? = null

    @Column(name = "commission_pct", precision = 2, scale = 2)
    open var commissionPct: BigDecimal? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    open var manager: Employee? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    open var department: Department? = null
}