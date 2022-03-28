package com.ex.kotlinspringboot.exception

import mu.KLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalControllerAdvice: ResponseEntityExceptionHandler() {

    companion object: KLogging()

    @ExceptionHandler(CourseNotFoundException::class)
    fun handleCourseNotFoundException(ex: CourseNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(ex.message!!, LocalDateTime.now(), HttpStatus.BAD_REQUEST.value())
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        logger.error("MethodArgumentNotValidException occurred. message=${ex.fieldError?.defaultMessage}")

        val body = mutableMapOf<String, Any>()

        body["timestamp"] = LocalDateTime.now()
        body["statusCode"] = HttpStatus.BAD_REQUEST.value()

        val errors = ex.bindingResult.fieldErrors.map {
            fieldError -> fieldError.defaultMessage
        }
        body["errors"] = errors

        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }
}