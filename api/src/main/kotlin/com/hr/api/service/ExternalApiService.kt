package com.hr.api.service

import com.hr.api.service.externalApis.MinWageService
import external.MinWagePerYearResponse
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class ExternalApiService(
    private val minWageService: MinWageService,
) {
    fun search(page: Int, perPage: Int): MinWagePerYearResponse {
        val response = minWageService.search(page, perPage)
        return response
    }

    fun searchAsync(page: Int, perPage: Int): CompletableFuture<MinWagePerYearResponse> {
        val response = minWageService.search(page, perPage)
        return CompletableFuture.completedFuture(response)
    }
}