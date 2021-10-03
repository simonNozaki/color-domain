package io.example.color.usecase

import io.example.color.domain.model.Color
import io.example.color.domain.type.RgbSaturation
import io.example.color.presentation.dto.AddColorRequest
import org.springframework.stereotype.Service

/**
 * ユースケース: 加法混色
 */
@Service
class AddColorUseCase {

    /**
     * ユースケースの実行
     * @param req DTO
     */
    fun execute(req: AddColorRequest): Color {
        // 16進数形式チェック
        // 色が16進数2桁であることはドメイン知識なのでドメイン層で対処する
        val base = Color(
            RgbSaturation(req.base.substring(0, 2)),
            RgbSaturation(req.base.substring(2, 4)),
            RgbSaturation(req.base.substring(4, 6))
        )
        val adding = Color(
            RgbSaturation(req.adding.substring(0, 2)),
            RgbSaturation(req.adding.substring(2, 4)),
            RgbSaturation(req.adding.substring(4, 6))
        )

        // 混色、レスポンス化
        return base.add(adding)
    }
}
