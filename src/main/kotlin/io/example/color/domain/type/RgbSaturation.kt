package io.example.color.domain.type

import java.lang.IllegalArgumentException

/**
 * RGB16進数彩度オブジェクト。
 * 16進数表記の色の要素となる。
 */
@JvmInline
value class RgbSaturation (
    val value: String
        ) {

    // ガード節
    init {
        if (this.value.isEmpty() || this.value.length != 2) {
            throw IllegalArgumentException("R, G, Bの任意の桁数が指定されていません")
        }

        val notHexes = listOf(this.value.substring(0, 1), this.value.substring(1, 2))
            .filterNot { it.toIntOrNull(16) === null }
            .count()

        // 1個でも16進数ではない文字がある
        if (notHexes > 0) {
            throw IllegalArgumentException("R, G, Bが16進数形式ではありません")
        }
    }

    /**
     * 引数に指定された色を混ぜる。加色。
     * @param hex 16進数形式の色
     */
    fun add(hex: RgbSaturation): RgbSaturation {
        val colorHex1 = hex.value.toInt(16)
        val colorHex2 = hex.value.toInt(16)

        val result = if(colorHex1 + colorHex2 > "FF".toInt(16)) "FF".toInt(16) else colorHex1 + colorHex2

        return RgbSaturation(Integer.toHexString(result))
    }
}