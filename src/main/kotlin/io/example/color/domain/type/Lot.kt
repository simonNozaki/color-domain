package io.example.color.domain.type

import java.lang.IllegalArgumentException

/**
 * 受注ロット数オブジェクトクラス。
 */
@JvmInline
value class Lot (val value: Int) {
    // ガード節
    init {
        if (this.value < 0 || this.value > 100) {
            throw IllegalArgumentException("validation.type.lot.invalid_number")
        }
    }
}