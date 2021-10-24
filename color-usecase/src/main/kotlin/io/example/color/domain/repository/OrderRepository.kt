package io.example.color.domain.repository

import io.example.color.domain.model.Color
import io.example.color.domain.model.Order
import io.example.color.domain.type.Lot


/**
 * 注文リポジトリインターフェース
 */
interface OrderRepository {
    fun add(color: Color, lot: Lot, fit: String, size: String): Order

    fun persistent(order: Order): Order
}
