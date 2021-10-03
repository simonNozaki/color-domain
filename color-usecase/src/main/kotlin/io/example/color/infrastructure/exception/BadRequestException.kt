package io.example.color.infrastructure.exception

import java.lang.RuntimeException

/**
 * BadRequest例外
 */
class BadRequestException(override var message: String) : RuntimeException(message)