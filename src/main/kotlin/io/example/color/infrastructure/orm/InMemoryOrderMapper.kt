package io.example.color.infrastructure.orm

import io.example.color.domain.model.Order
import java.util.Date
import java.util.UUID

/**
 * 注文レコードインメモリマッパ
 */
class InMemoryOrderMapper : OrderMapper {

    override fun persistent(order: Order) {
        // uuid
        val id = UUID.randomUUID().toString()
        // システム日付
        val now = Date().toString()

        // ドメインオブジェクトと他に必要なID項目くっつけてDB用レコードに

        println("インメモリオブジェクト書き込み成功")
    }
}
