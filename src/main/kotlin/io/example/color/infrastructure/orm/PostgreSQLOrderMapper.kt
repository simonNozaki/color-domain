package io.example.color.infrastructure.orm

import io.example.color.domain.model.Order

/**
 * PostgreSQL用注文レコードマッパー実装
 */
class PostgreSQLOrderMapper : OrderMapper {
    override fun persistent(order: Order) {
        // TODO あとでそれっぽいコード書く

        println("データベース永続化成功")
    }
}
