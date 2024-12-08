package com.hr.api.repository.external

import com.core.log.logger
import com.hr.api.repository.ExternalRepository
import external.MinWagePerYearResponse
import external.feign.PublicClient
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class MinWageRepository(
    private val publicClient: PublicClient,
): ExternalRepository {
    override fun getMinWage(page: Int, perPage: Int): MinWagePerYearResponse {
        logger.info { "[MinWageRepository.getMinWage] page $page and perPage $perPage" }
        val minWagePerYearResponse = publicClient.search(page, perPage)
            ?: MinWagePerYearResponse(
                0,
                listOf(),
                0,
                0,
                0,
                0
            )
        return minWagePerYearResponse
    }

//    private fun createResponse(minWagePerYear: MinWagePerYear){
//        return
//    }
}


