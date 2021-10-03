package io.example.color.domain.model

import io.example.color.domain.type.FitEnum
import io.example.color.domain.type.Lot
import io.example.color.domain.type.SizeEnum
import io.example.color.infrastructure.orm.OrderMapper

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
     * @param orderMapper 永続化可能な注文オブジェクトレコードマッパー
     */
    fun save(orderMapper: OrderMapper) {
        orderMapper.persistent(this)
    }
}