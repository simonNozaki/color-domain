package io.example.color.domain.type

import io.example.color.infrastructure.exception.AppValidationException
import java.lang.IllegalArgumentException

/**
 * 受注ロット数オブジェクトクラス。
 */
@JvmInline
value class Lot (val value: Int) {
    // ガード節
    init {
        if (this.value < 0 || this.value > 100) {
            throw AppValidationException("受注ロット数が以上です。1つ以上100個以下に設定してください")
        }
    }
}