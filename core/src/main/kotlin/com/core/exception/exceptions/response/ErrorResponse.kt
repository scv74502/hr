package com.core.exception.exceptions.response

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val status: HttpStatus,
    val error: String,
    val message: Map<String, String>?,
) {
    constructor(status: HttpStatus, error: String) : this(LocalDateTime.now(), status, error, emptyMap())
    constructor(status: HttpStatus, error: String, message: Map<String, String>?) : this(LocalDateTime.now(), status, error, message)
}