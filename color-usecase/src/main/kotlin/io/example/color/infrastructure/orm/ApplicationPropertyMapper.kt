package io.example.color.infrastructure.orm

/**
 * マスターテーブルマッパーインターフェース
 */
interface ApplicationPropertyMapper {
    /**
     * グループとキーで値マスターデータの参照
     */
    fun get(group: String, key: String): Pair<String, String>
}
