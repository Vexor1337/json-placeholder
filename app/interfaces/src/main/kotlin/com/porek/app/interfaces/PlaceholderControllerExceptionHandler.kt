package com.porek.app.interfaces

import com.porek.app.commons.*
import com.porek.app.commons.web.ErrorResponseWrapper
import com.porek.app.commons.web.toErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


class PlaceholderEitherException(
    val eitherError: PlaceholderError, val status: HttpStatus = HttpStatus.BAD_REQUEST
) : RuntimeException()

fun PlaceholderError.toException(status: HttpStatus = HttpStatus.BAD_REQUEST) =
    PlaceholderEitherException(eitherError = this, status = status)

@RestControllerAdvice(
    basePackages = ["com.porek.app.intdrfaces"]
)

@Order(100)
class PlaceholderControllerExceptionHandler {

    @ExceptionHandler(PlaceholderEitherException::class)
    fun handleRuntimeException(exception: PlaceholderEitherException): ResponseEntity<ErrorResponseWrapper> =
        when (val e = exception.eitherError)  {
            is PlaceholderGenericException -> e.message.toErrorResponse(HttpStatus.BAD_REQUEST)
            is PageNotFoundError -> e.message.toErrorResponse(HttpStatus.NOT_FOUND)
            is PlaceholderUnauthorizedException -> e.message.toErrorResponse(HttpStatus.UNAUTHORIZED)
            is PostRepoGenericError -> e.message.toErrorResponse(HttpStatus.BAD_REQUEST)
        }
}