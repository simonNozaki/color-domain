package io.example.color.usecase

import io.example.color.domain.model.Color
import io.example.color.domain.model.Color.ColorMixInRequest
import io.example.color.domain.model.Color.ColorMixInResponse
import io.example.color.infrastructure.exception.BadRequestException
import org.springframework.stereotype.Service

/**
 * 混色サービス
 */
@Service
class ColorMixInService {

    fun execute(req: ColorMixInRequest): ColorMixInResponse {
        // 変換チェック
        if (!req.isConvertable()) {
            throw BadRequestException("オブジェクトの変換に失敗")
        }

        // 16進数形式チェック
        val mixedIn = Color(req.mixedIn)
        val mixingIn = Color(req.mixingIn)
        if ((mixedIn.isColorHex() && mixingIn.isColorHex())) {
            throw BadRequestException("引数が16進数の形式ではありません")
        }

        // 混色、レスポンス化
        return mixedIn.mixIn(mixingIn).toResponse()
    }
}