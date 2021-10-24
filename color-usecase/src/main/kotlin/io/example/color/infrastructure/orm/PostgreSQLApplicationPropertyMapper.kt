package io.example.color.infrastructure.orm

import io.example.color.infrastructure.exception.AppValidationException
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesMapper
import io.example.color.infrastructure.orm.generated.selectByPrimaryKey

/**
 * PostgreSQL用アプリケーションプロパティ実装クラス
 */
class PostgreSQLApplicationPropertyMapper : ApplicationPropertyMapper {
    override fun get(group: String, key: String): Pair<String, String> {
        // pkで検索
        val result = SqlSessionFactory.getSqlSessionFactory().openSession().use {
            return@use it.getMapper(ApplicationPropertiesMapper::class.java)
                .selectByPrimaryKey(group, key)
        }
        if (result == null) {
            throw AppValidationException("検索結果がありません => group: $group, key: $key")
        }

        println("キー検索結果 => $result")

        return "$group$key" to result.value!!
    }
}
