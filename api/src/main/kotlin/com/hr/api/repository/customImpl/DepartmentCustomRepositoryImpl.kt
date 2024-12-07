package com.hr.api.repository.customImpl

import com.hr.api.controller.response.DeptInfoResponse
import com.hr.api.repository.custom.DepartmentCustomRepository
import com.hr.domain.entity.*
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class DepartmentCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): DepartmentCustomRepository {
    val manager = QEmployee.employee
    val location = QLocation.location
    val country = QCountry.country
    val region = QRegion.region
    val department: QDepartment = QDepartment.department

    override fun findDeptInfoById(id: Long): DeptInfoResponse? {
        return queryFactory
            .select(
                Projections.bean(
                    DeptInfoResponse::class.java,
                    department.departmentName.`as`("departmentName"),
                    manager.firstName.concat(" ").concat(manager.lastName).`as`("managerName"),
                    location.streetAddress.`as`("streetAddress"),
                    location.postalCode.`as`("postalCode"),
                    location.city.`as`("city"),
                    location.stateProvince.`as`("stateProvince"),
                    country.countryName.`as`("countryName"),
                    region.regionName.`as`("regionName")
                )
            )
            .from(department)
            .leftJoin(department.manager, manager)
            .leftJoin(department.location, location)
            .leftJoin(location.country, country)
//            .leftJoin(country.region, region)
            .where(department.id.eq(id))
            .fetchOne()
    }
}

