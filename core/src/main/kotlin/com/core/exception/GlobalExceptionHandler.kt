package com.core.exception

import com.core.exception.exceptions.DefaultException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import com.core.exception.exceptions.response.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(DefaultException::class)
    fun handleDefaultException(ex: DefaultException): ResponseEntity<ErrorResponse> {
        println("[handleDefaultException] occured!")
        val errorResponse = ErrorResponse(
            ex.exceptionCode.status,
            ex.exceptionCode.message,
        )
        return ResponseEntity(errorResponse, ex.exceptionCode.status)
    }
}