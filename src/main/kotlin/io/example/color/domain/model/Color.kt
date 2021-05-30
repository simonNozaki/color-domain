package io.example.color.domain.model


/**
 * 色を表現する値オブジェクト
 */
data class Color (
    /**
     * 16進数表現: R
     */
    var red: String,
    /**
     * 16進数表現: G
     */
    var green: String,
    /**
     * 16進数表現: B
     */
    var blue: String
) {

    /**
     * 3色とも16進数2桁の色表現となっている
     */
    fun isColorHex(): Boolean {
        return elementIsHexToDigit(this.red) && elementIsHexToDigit(green) && elementIsHexToDigit(blue)
    }

    private fun elementIsHexToDigit(element: String): Boolean {
        if (element.isEmpty() || element.length != 2) return false

        val notHexes = listOf(element.substring(0, 1), element.substring(1, 2))
            .filterNot { it.toIntOrNull(16) === null }
            .count()

        // 1個でも16進数ではない文字がある
        if (notHexes > 0) return false

        return true
    }

    /**
     * 2つの色を混ぜて、色を返す。ビジネスルールを満たしている前提で動く。
     * ドメインロジック。
     */
    fun mixIn(req: Color): Color {
        val r = add(this.red, req.red)
        val g = add(this.green, req.green)
        val b = add(this.blue, req.blue)

        return Color(r, g, b)
    }

    /**
     * 2桁の16進数同士を計算する
     */
    private fun add(hex1: String, hex2: String): String {
        val colorHex1 = hex1.toInt(16)
        val colorHex2 = hex2.toInt(16)

        val result = if(colorHex1 + colorHex2 > "FF".toInt(16)) "FF".toInt(16) else colorHex1 + colorHex2

        return Integer.toHexString(result)
    }
}

/**
 * ドメインオブジェクトのファクトリメソッド
 */
fun colorOf(r: String, g: String, b: String): Color {
    return Color(r, g, b)
}