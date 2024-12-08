package com.hr.api.controller

import com.core.log.logger
import com.hr.api.controller.request.MinWageSearchRequest
import com.hr.api.service.ExternalApiService
import external.MinWagePerYearResponse
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

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
        val futureResponse = externalApiService.searchAsync(request.page, request.perPage)
        return try{
            futureResponse.get(40, TimeUnit.SECONDS)
        } catch(e: TimeoutException){
            throw ResponseStatusException(HttpStatus.REQUEST_TIMEOUT, "응답시간 초과")
        }
    }
}