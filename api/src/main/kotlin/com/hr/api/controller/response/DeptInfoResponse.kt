package com.hr.api.controller.response

data class DeptInfoResponse (
    var departmentName: String? = null,
    var managerName: String? = null,
    var streetAddress: String? = null,
    var postalCode: String? = null,
    var city: String? = null,
    var stateProvince: String? = null,
    var countryName: String? = null,
    var regionName: String? = null
)