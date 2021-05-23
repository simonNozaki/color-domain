package io.example.color.infrastructure.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 * 共通エラーハンドラ
 */
@RestControllerAdvice
class GeneralErrorAdvice: ResponseEntityExceptionHandler() {

    /**
     * 検査系例外をさばく
     * @param e
     * @param request
     */
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(e: BadRequestException, request: WebRequest): ResponseEntity<Any> {
        return super.handleExceptionInternal(e, Error(null, listOf(e.message)), HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }

    /**
     * 汎用エラーオブジェクト
     * TODO たぶんここに置くのよくないのであとで場所変える
     */
    private data class Error(
        val id: String?,
        val message: List<String>
    )
}