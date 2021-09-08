package io.example.color.presentation.api

import io.example.color.presentation.dto.SubtractColorRequest
import io.example.color.presentation.dto.SubtractColorResponse
import io.example.color.usecase.SubtractColorUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

/**
 * 減法混色REST Controller
 */
@RestController
class SubtractColorRestController(private val subtractColorUseCase: SubtractColorUseCase) {

    @RequestMapping(
        value = ["color/subtract"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        method = [RequestMethod.POST]
    )
    fun execute(req: SubtractColorRequest): SubtractColorResponse {
        if (!req.canConvert()) {
            throw IllegalArgumentException("validation.req.invalid_formant")
        }

        val color = subtractColorUseCase.execute(req)

        return SubtractColorResponse(
            color.red.value + color.green.value + color.blue.value
        )
    }

    private fun SubtractColorRequest.canConvert(): Boolean {
        if (this.base.isEmpty() || this.base.length != 6) return false
        if (this.subtracting.isEmpty() || this.subtracting.length != 6) return false
        return true
    }
}
