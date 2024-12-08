package com.hr.api.controller

import com.core.log.logger
import com.hr.api.controller.request.MinWageSearchRequest
import com.hr.api.service.ExternalApiService
import external.MinWagePerYearResponse
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/v1/public/min-wage")
@RequiredArgsConstructor
class ExternalApiController(
    val externalApiService: ExternalApiService,
) {
    @GetMapping
    fun searchMinWage(@Valid request: MinWageSearchRequest): MinWagePerYearResponse{
        logger.info { "[ExternalApiController.searchMinWage] search = {${request}}" }
        return externalApiService.search(request.page, request.perPage)
    }
}