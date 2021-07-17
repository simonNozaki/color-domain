package io.example.color.domain.type

import java.lang.IllegalArgumentException

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
            throw IllegalArgumentException("validation.model.rgb_saturation.empty")
        }

        val notHexes = listOf(this.value.substring(0, 1), this.value.substring(1, 2))
            .filterNot { it.toIntOrNull(16) === null }
            .count()

        // 1個でも16進数ではない文字がある
        if (notHexes > 0) {
            throw IllegalArgumentException("validation.model.rgb_saturation.not_hex_format")
        }
    }

    /**
     * 引数に指定された色を混ぜる。加色。
     * @param hex 16進数形式の色
     */
    fun add(hex: RgbSaturation): RgbSaturation {
        val base = this.value.toInt(16)
        val hexInt = hex.value.toInt(16)

        val result = if (base + hexInt > "FF".toInt(16)) "FF".toInt(16) else base + hexInt

        return RgbSaturation(Integer.toHexString(result))
    }

    /**
     * 色要素を混ぜる、減法混色
     * @param hex 16進数形式の色
     */
    fun subtract(hex: RgbSaturation): RgbSaturation {
        val base = this.value.toInt(16)
        val hexInt = hex.value.toInt(16)

        val result = if (base - hexInt < "00".toInt(16)) "00".toInt(16) else base - hexInt
        val hexString = Integer.toHexString(result)

        return RgbSaturation(hexString)
    }
}
