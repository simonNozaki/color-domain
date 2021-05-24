package io.example.color.usecase

import io.example.color.domain.model.Color
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
        val mixedIn = Color(req.mixedIn)
        val mixingIn = Color(req.mixingIn)
        if ((mixedIn.isColorHex() && mixingIn.isColorHex())) {
            throw BadRequestException("引数が16進数の形式ではありません")
        }

        // 混色、レスポンス化
        return mixedIn.mixIn(mixingIn)
    }
}