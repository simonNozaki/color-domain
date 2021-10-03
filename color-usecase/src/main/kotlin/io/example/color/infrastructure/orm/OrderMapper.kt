package io.example.color.infrastructure.orm

import io.example.color.domain.model.Order

/**
 * ドメインレコードマッパー
 */
interface OrderMapper {

    /**
     * 注文ドメインオブジェクトを永続化する
     * @param order 注文ドメインオブジェクト
     */
    fun persistent(order: Order)
}