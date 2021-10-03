package io.example.color.domain.type

import io.example.color.infrastructure.exception.AppValidationException

/**
 * RGB16進数彩度オブジェクト。
 * 16進数表記の色の要素となる。
 */
@JvmInline
value class RgbSaturation(
    val value: String
) {

    // ガード節
    init {
        if (this.value.isEmpty() || this.value.length != 2) {
            throw AppValidationException("R, G, Bの任意の桁数が指定されていません")
        }

        val notHexes = listOf(this.value.substring(0, 1), this.value.substring(1, 2))
            .filter { it.toIntOrNull(16) === null }
            .count()

        // 1個でも16進数ではない文字がある
        if (notHexes > 0) {
            throw AppValidationException("R, G, Bが16進数形式ではありません")
        }
    }

    /**
     * 引数に指定された色を混ぜる。加色。
     * @param hex 16進数形式の色
     */
    fun add(hex: RgbSaturation): RgbSaturation {
        val base = this.value.toInt(16)
        val additionHex = hex.value.toInt(16)

        val result = if (base + additionHex > "FF".toInt(16)) "FF".toInt(16) else base + additionHex
        var hexString = Integer.toHexString(result)
        if (hexString.length == 1) {
            hexString += "0"
        }

        return RgbSaturation(hexString)
    }

    /**
     * 色要素を混ぜる、減法混色
     * @param hex 16進数形式の色
     */
    fun subtract(hex: RgbSaturation): RgbSaturation {
        val base = this.value.toInt(16)
        val subtractedHex = hex.value.toInt(16)

        val result = if (base - subtractedHex < "00".toInt(16)) "00".toInt(16) else base - subtractedHex
        var hexString = Integer.toHexString(result)
        if (hexString.length == 1) {
            hexString += "0"
        }

        return RgbSaturation(hexString)
    }
}
