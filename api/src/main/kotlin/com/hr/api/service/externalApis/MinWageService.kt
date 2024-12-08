package com.hr.api.service.externalApis

import com.core.log.logger
import com.hr.api.repository.ExternalRepository
import external.MinWagePerYearResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class MinWageService(
    @Qualifier("minWageRepository")
    private val minWageRepository: ExternalRepository,
) {
    fun search(page: Int, perPage: Int): MinWagePerYearResponse {
        logger.info { "[MinWageService.search] page = $page, perPage = $perPage" }
        val result = minWageRepository.getMinWage(page, perPage)
        return result
    }
}