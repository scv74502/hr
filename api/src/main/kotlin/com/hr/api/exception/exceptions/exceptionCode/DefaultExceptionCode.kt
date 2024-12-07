package com.core.exception.exceptions.exceptionCode

import org.springframework.http.HttpStatus

enum class DefaultExceptionCode (
    val status: HttpStatus,
    val message: String,
){
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 리소스가 없습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청값입니다."),
}