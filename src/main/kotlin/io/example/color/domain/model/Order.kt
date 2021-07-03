package io.example.color.domain.model

import io.example.color.domain.type.FitEnum
import io.example.color.domain.type.Lot
import io.example.color.domain.type.SizeEnum

/**
 * 注文オブジェクト。
 */
data class Order(
    /** 受注ロット */
    val lot: Lot,
    /** サイズ */
    val size: SizeEnum,
    /** 色 */
    val color: Color,
    /** フィット感 */
    val fit: FitEnum
) {
    /**
     * 受注する
     * todo 永続化などもここで実行する
     */
    fun save() {

    }
}
