package io.example.color.domain.model

import io.example.color.domain.type.RgbSaturation


/**
 * 色を表現する値オブジェクト
 */
data class Color (
    /**
     * 16進数表現: R
     */
    var red: RgbSaturation,
    /**
     * 16進数表現: G
     */
    var green: RgbSaturation,
    /**
     * 16進数表現: B
     */
    var blue: RgbSaturation
) {

    /**
     * 2つの色を混ぜて、色を返す。ビジネスルールを満たしている前提で動く。
     * ドメインロジック。
     */
    fun mixIn(req: Color): Color {
        val r = this.red.add(req.red)
        val g = this.green.add(req.green)
        val b = this.blue.add(req.blue)

        return Color(r, g, b)
    }
}