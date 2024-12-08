package com.hr.api.repository

import external.MinWagePerYearResponse

interface ExternalRepository {
    fun getMinWage(page: Int, perPage: Int): MinWagePerYearResponse
}