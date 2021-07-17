package io.example.color.presentation.api

import io.example.color.presentation.dto.OrderClothesRequest
import io.example.color.usecase.OrderClothesUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * 受注REST Controller
 */
@RestController
class OrderClothesRestController(private val orderClothesUseCase: OrderClothesUseCase) {

    @RequestMapping(
        value = ["order/cloth"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        method = [RequestMethod.POST]
    )
    fun execute(@RequestBody req: OrderClothesRequest) {
        // ユースケースの実行
        orderClothesUseCase.execute(req)
    }
}
