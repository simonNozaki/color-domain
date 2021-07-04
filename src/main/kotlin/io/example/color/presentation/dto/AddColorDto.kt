package io.example.color.presentation.dto

import io.example.color.infrastructure.Dto

/**
 * 混色リクエストDTO。
 */
data class AddColorRequest (
    /**
     * 混ぜられる色
     */
    var base: String,

    /**
     * 混ぜる色
     */
    var adding: String
): Dto

/**
 * 混色レスポンスDTO
 */
data class AddColorResponse (
    var newColor: String
): Dto