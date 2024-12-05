package com.core.exception.exceptions.response

import org.springframework.http.HttpStatus
import org.springframework.web.ErrorResponse
import java.time.LocalDateTime

data class DefaultErrorResponse(
    val message: String,
    val httpStatus: HttpStatus,
    val error: String,
    val timestamp: LocalDateTime
)

