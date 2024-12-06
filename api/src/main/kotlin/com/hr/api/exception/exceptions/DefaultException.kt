package com.core.exception.exceptions

import com.core.exception.exceptions.exceptionCode.DefaultExceptionCode

class DefaultException(val exceptionCode: DefaultExceptionCode): RuntimeException(exceptionCode.message)