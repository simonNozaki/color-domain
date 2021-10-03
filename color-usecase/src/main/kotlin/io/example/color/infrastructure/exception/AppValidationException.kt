package io.example.color.infrastructure.exception

/**
 * アプリケーションバリデーション例外
 */
class AppValidationException (override val message: String) : RuntimeException(message)