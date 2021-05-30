package io.example.color.usecase

import io.example.color.domain.model.Color
import io.example.color.domain.model.colorOf
import io.example.color.infrastructure.exception.BadRequestException
import io.example.color.presentation.dto.ColorMixInRequest
import org.springframework.stereotype.Service

/**
 * ユースケース: 色を混ぜる
 */
@Service
class MixInColorUseCase {

    fun execute(req: ColorMixInRequest): Color {
        // 16進数形式チェック
        // 色が16進数2桁であることはドメイン知識なのでドメイン層で対処する
        val mixedIn = colorOf(
            req.mixedIn.substring(0, 2),
            req.mixedIn.substring(2, 4),
            req.mixedIn.substring(4, 6)
        )
        val mixingIn = colorOf(
            req.mixingIn.substring(0, 2),
            req.mixingIn.substring(2, 4),
            req.mixingIn.substring(4, 6)
        )
        if ((mixedIn.isColorHex() && mixingIn.isColorHex())) {
            throw BadRequestException("引数が16進数の形式ではありません")
        }

        // 混色、レスポンス化
        return mixedIn.mixIn(mixingIn)
    }
}