package io.example.color.usecase

import io.example.color.domain.model.Color
import io.example.color.domain.repository.OrderRepository
import io.example.color.domain.type.Lot
import io.example.color.domain.type.RgbSaturation
import io.example.color.presentation.dto.OrderClothesRequest
import org.springframework.stereotype.Service

/**
 * オリジナルの洋服を注文するユースケース
 */
@Service
class OrderClothesUseCase(
    private val orderRepository: OrderRepository
) {

    /**
     * ユースケースの実行
     */
    fun execute(req: OrderClothesRequest) {
        val color = Color(
            RgbSaturation(req.color.substring(0, 2)),
            RgbSaturation(req.color.substring(2, 4)),
            RgbSaturation(req.color.substring(4, 6))
        )

        // 発注の生成
        val order = this.orderRepository.add(color, Lot(req.lot), req.fit, req.size.toString())

        // 受注する
        this.orderRepository.persistent(order)
    }
}
