package io.example.color.presentation.api

import io.example.color.domain.model.Color.ColorMixInRequest
import io.example.color.domain.model.Color.ColorMixInResponse
import io.example.color.usecase.ColorMixInService
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
class ColorMixInRestController(private val colorMixInService: ColorMixInService) {

    @RequestMapping(
        value = ["color/mixin"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        method = [RequestMethod.POST]
    )
    fun execute(@RequestBody req: ColorMixInRequest): ColorMixInResponse {
        return colorMixInService.execute(req)
    }
}