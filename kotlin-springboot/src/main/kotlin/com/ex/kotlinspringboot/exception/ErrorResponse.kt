package com.ex.kotlinspringboot.exception

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse (

    var message: String,
    var timestamp: LocalDateTime,
    var statusCode: Int
)
