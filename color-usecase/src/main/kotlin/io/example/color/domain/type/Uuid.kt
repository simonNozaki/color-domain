package io.example.color.domain.type

/**
 * UUIDインターフェース
 */
interface Uuid {
    /**
     * 内部で新規IDを発番する
     */
    fun create(): Uuid

    /**
     * 発番したUUIDを返す
     */
    fun get(): String
}
