package com.hr.api.service

import com.core.log.logger
import com.hr.api.service.externalApis.MinWageService
import external.MinWagePerYearResponse
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class ExternalApiService(
    private val minWageService: MinWageService,
) {
    fun search(page: Int, perPage: Int): MinWagePerYearResponse {
        logger.info { "[ExternalApiService.search] page:$page, perPage:$perPage" }
        val response = minWageService.search(page, perPage)
        return response
    }

    @Async
    fun searchAsync(page: Int, perPage: Int): CompletableFuture<MinWagePerYearResponse> {
        logger.info { "[ExternalApiService.searchAsync] page:$page, perPage:$perPage" }
        val response = minWageService.search(page, perPage)
        return CompletableFuture.completedFuture(response)
    }
}