package com.hr.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate
import java.io.Serializable
import java.time.LocalDate
import java.util.*

@Embeddable
open class JobHistoryId : Serializable {
    @Column(name = "employee_id", columnDefinition = "int UNSIGNED not null")
    open var employeeId: Long? = null

    @NotNull
    @Column(name = "start_date", nullable = false)
    open var startDate: LocalDate? = null
    override fun hashCode(): Int = Objects.hash(employeeId, startDate)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as JobHistoryId

        return employeeId == other.employeeId &&
                startDate == other.startDate
    }

    companion object {
        private const val serialVersionUID = -8166225114585555951L
    }
}