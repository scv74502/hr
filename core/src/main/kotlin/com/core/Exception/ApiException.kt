package com.core.Exception;

import lombok.Getter
import org.springframework.http.HttpStatus

@Getter
class ApiException(private val errorMsg: String, private val errorType: ErrorType, private val httpStatus: HttpStatus) :
    RuntimeException()

