package io.example.color.domain.type

import org.springframework.stereotype.Component
import java.util.UUID

/**
 * UUID基本実装
 */
@Component
class BasicUuid : Uuid {
    private var _id: String = ""
    override fun create(): Uuid {
        this._id = UUID.randomUUID().toString()
        return this
    }

    override fun get(): String {
        return this._id
    }
}
