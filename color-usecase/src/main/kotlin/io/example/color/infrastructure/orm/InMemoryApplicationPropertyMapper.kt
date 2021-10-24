package io.example.color.infrastructure.orm

import io.example.color.infrastructure.exception.AppValidationException

/**
 * マスターテーブルインメモリ実装クラス
 */
class InMemoryApplicationPropertyMapper : ApplicationPropertyMapper {
    // 本番用にはDBクライアントを用いたクエリ、マッピングの実装などをここに書く
    private val kvs = mapOf(
        Pair("ORDER.SIZE", "40") to "40",
        Pair("ORDER.SIZE", "42") to "40",
        Pair("ORDER.SIZE", "44") to "40",
        Pair("ORDER.SIZE", "46") to "40",
        Pair("ORDER.FIT", "SKINNY") to "SKINNY",
        Pair("ORDER.FIT", "NORMAL") to "NORMAL",
        Pair("ORDER.FIT", "LOOSE") to "LOOSE",
    )

    override fun get(group: String, key: String): Pair<String, String> {
        val result = this.kvs[group to key]
        if (result == null) {
            throw AppValidationException("")
        }
        return Pair("$group$key", result)
    }
}
