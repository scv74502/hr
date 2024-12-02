package com.hr.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "departments")
open class Department {
    @Id
    @Column(name = "department_id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Size(max = 30)
    @NotNull
    @Column(name = "department_name", nullable = false, length = 30)
    open var departmentName: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    open var manager: Employee? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    open var location: Location? = null
}