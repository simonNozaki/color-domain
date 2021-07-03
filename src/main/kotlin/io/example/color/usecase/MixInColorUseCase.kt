package io.example.color.usecase

import io.example.color.domain.model.Color
import io.example.color.domain.type.RgbSaturation
import io.example.color.presentation.dto.ColorMixInRequest
import org.springframework.stereotype.Service

/**
 * ユースケース: 色を混ぜる
 */
@Service
class MixInColorUseCase {

    /**
     * ユースケースの実行
     * @param req DTO
     */
    fun execute(req: ColorMixInRequest): Color {
        // 16進数形式チェック
        // 色が16進数2桁であることはドメイン知識なのでドメイン層で対処する
        val mixedIn = Color(
            RgbSaturation(req.mixedIn.substring(0, 2)),
            RgbSaturation(req.mixedIn.substring(2, 4)),
            RgbSaturation(req.mixedIn.substring(4, 6))
        )
        val mixingIn = Color(
            RgbSaturation(req.mixingIn.substring(0, 2)),
            RgbSaturation(req.mixingIn.substring(2, 4)),
            RgbSaturation(req.mixingIn.substring(4, 6))
        )

        // 混色、レスポンス化
        return mixedIn.mixIn(mixingIn)
    }
}