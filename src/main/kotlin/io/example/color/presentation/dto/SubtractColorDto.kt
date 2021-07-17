package io.example.color.presentation.dto

import io.example.color.infrastructure.Dto
import java.io.Serializable

/**
 * 減法混色リクエスト
 */
data class SubtractColorRequest(
    /**
     * 混ぜられる色
     */
    var base: String,

    /**
     * 混ぜる色
     */
    var subtracting: String
) : Dto, Serializable

/**
 * 減法混色レスポンス
 */
class SubtractColorResponse(
    val newColor: String
)
