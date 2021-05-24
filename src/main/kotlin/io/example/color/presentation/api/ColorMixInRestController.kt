package io.example.color.presentation.api

import io.example.color.domain.model.Color
import io.example.color.infrastructure.exception.BadRequestException
import io.example.color.presentation.dto.ColorMixInRequest
import io.example.color.presentation.dto.ColorMixInResponse
import io.example.color.usecase.MixInColorUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * 色RESTコントローラ
 * HTTPメソッドの受付、クライアントへの返却など最小限の責務を負う
 */
@RestController
class ColorMixInRestController(private val mixInColorUseCase: MixInColorUseCase) {

    @RequestMapping(
        value = ["color/mixin"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        method = [RequestMethod.POST]
    )
    fun execute(@RequestBody req: ColorMixInRequest): ColorMixInResponse {
        // 変換判定
        if (!req.isConvertable()) {
            throw BadRequestException("オブジェクトの変換に失敗")
        }

        return mixInColorUseCase.execute(req).toResponse()
    }

    /**
     * Colorオブジェクトに変換できることを確認する拡張関数
     * 変換可能性判定は本質的にドメイン知識と関わりが薄いのでPresentation層で扱ってしまう
     */
    private fun ColorMixInRequest.isConvertable(): Boolean {
        if (this.mixedIn.isEmpty() || this.mixedIn.length != 6) return false
        if (this.mixingIn.isEmpty() || this.mixingIn.length != 6) return false
        return true
    }

    /**
     * ドメインオブジェクトをpresentation層のDTOに差し替える
     * ドメイン知識とは無関係なのでpresentationで扱う
     */
    private fun Color.toResponse(): ColorMixInResponse {
        return ColorMixInResponse(this.red + this.green + this.blue)
    }

}