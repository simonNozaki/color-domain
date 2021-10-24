package io.example.color.infrastructure.repository

import io.example.color.domain.model.Color
import io.example.color.domain.model.Order
import io.example.color.domain.repository.OrderRepository
import io.example.color.domain.type.FitEnum
import io.example.color.domain.type.Lot
import io.example.color.domain.type.SizeEnum
import io.example.color.domain.type.Uuid
import io.example.color.infrastructure.orm.ApplicationPropertyMapper
import org.springframework.stereotype.Repository

/**
 * 注文リポジトリインメモリ実装
 */
@Repository
class InMemoryOrderRepository(
    private val applicationPropertyMapper: ApplicationPropertyMapper,
    private val uuid: Uuid
) : OrderRepository {
    override fun add(color: Color, lot: Lot, fit: String, size: String): Order {
        // サイズ
        val rawSize = this.applicationPropertyMapper.get("ORDER.SIZE", size)
        val sizeValue = SizeEnum.valueOf(rawSize.second)
        // フィット
        val rawFit = this.applicationPropertyMapper.get("ORDER.FIT", fit)
        val fitValue = FitEnum.valueOf(rawFit.second)

        val order = Order(
            this.uuid.create(),
            lot,
            sizeValue,
            color,
            fitValue
        )

        println("生成した注文エンティティ: $order")

        return order
    }

    override fun persistent(order: Order): Order {
        println("発注の永続化")
        return order
    }
}
