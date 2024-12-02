package com.hr.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size

@Entity
@Table(name = "regions")
open class Region {
    @Id
    @Column(name = "region_id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Size(max = 25)
    @Column(name = "region_name", length = 25)
    open var regionName: String? = null
}