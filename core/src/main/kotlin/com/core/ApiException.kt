package com.core

import org.springframework.http.HttpStatus

data class ApiException(
    val errorMessage: String,
    val externalApiError: ErrorType,
    val valueOf: HttpStatus
) :RuntimeException()