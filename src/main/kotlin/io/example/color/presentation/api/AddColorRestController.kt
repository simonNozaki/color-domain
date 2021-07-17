package io.example.color.presentation.api

import io.example.color.domain.model.Color
import io.example.color.infrastructure.exception.BadRequestException
import io.example.color.presentation.dto.AddColorRequest
import io.example.color.presentation.dto.AddColorResponse
import io.example.color.usecase.AddColorUseCase
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
class AddColorRestController(private val addColorUseCase: AddColorUseCase) {

    @RequestMapping(
        value = ["color/add"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        method = [RequestMethod.POST]
    )
    fun execute(@RequestBody req: AddColorRequest): AddColorResponse {
        // 変換判定
        if (!req.canConvert()) {
            throw BadRequestException("validation.req.invalid_formant")
        }

        return addColorUseCase.execute(req).toResponse()
    }

    /**
     * Colorオブジェクトに変換できることを確認する拡張関数
     * 変換可能性判定は本質的にドメイン知識と関わりが薄いのでPresentation層で扱ってしまう
     */
    private fun AddColorRequest.canConvert(): Boolean {
        if (this.base.isEmpty() || this.base.length != 6) return false
        if (this.adding.isEmpty() || this.adding.length != 6) return false
        return true
    }

    /**
     * ドメインオブジェクトをpresentation層のDTOに差し替える
     * ドメイン知識とは無関係なのでpresentationで扱う
     */
    private fun Color.toResponse(): AddColorResponse {
        return AddColorResponse(this.red.value + this.green.value + this.blue.value)
    }
}
