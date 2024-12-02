package com.hr.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "locations")
open class Location {
    @Id
    @Column(name = "location_id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Size(max = 40)
    @Column(name = "street_address", length = 40)
    open var streetAddress: String? = null

    @Size(max = 12)
    @Column(name = "postal_code", length = 12)
    open var postalCode: String? = null

    @Size(max = 30)
    @NotNull
    @Column(name = "city", nullable = false, length = 30)
    open var city: String? = null

    @Size(max = 25)
    @Column(name = "state_province", length = 25)
    open var stateProvince: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    open var country: Country? = null
}