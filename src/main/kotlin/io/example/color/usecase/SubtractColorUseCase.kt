package io.example.color.usecase

import io.example.color.domain.model.Color
import io.example.color.domain.type.RgbSaturation
import io.example.color.presentation.dto.SubtractColorRequest
import org.springframework.stereotype.Service

/**
 * 色を混ぜる：減法混色
 */
@Service
class SubtractColorUseCase {

    /**
     * ユースケースの実行
     * @param req DTO
     */
    fun execute(req: SubtractColorRequest): Color {
        val base = Color(
            RgbSaturation(req.base.substring(0, 2)),
            RgbSaturation(req.base.substring(2, 4)),
            RgbSaturation(req.base.substring(4, 6))
        )
        val subtracting = Color(
            RgbSaturation(req.subtracting.substring(0, 2)),
            RgbSaturation(req.subtracting.substring(2, 4)),
            RgbSaturation(req.subtracting.substring(4, 6))
        )

        return base.subtract(subtracting)
    }
}