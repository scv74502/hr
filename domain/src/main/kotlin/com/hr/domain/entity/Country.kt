package com.hr.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "countries")
open class Country {
    @Id
    @Size(max = 2)
    @Column(name = "country_id", nullable = false, length = 2, columnDefinition = "VARCHAR(2)")
    open var countryId: String? = null

    @Size(max = 40)
    @Column(name = "country_name", length = 40)
    open var countryName: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    open var region: Region? = null
}