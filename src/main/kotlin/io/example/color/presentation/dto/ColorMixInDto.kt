package io.example.color.presentation.dto

import io.example.color.infrastructure.Dto

/**
 * 混色リクエストDTO。
 */
data class ColorMixInRequest (
    /**
     * 混ぜられる色
     */
    var mixedIn: String,

    /**
     * 混ぜる色
     */
    var mixingIn: String
): Dto

/**
 * 混色レスポンスDTO
 */
data class ColorMixInResponse (
    var newColor: String
): Dto