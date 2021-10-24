package io.example.color.infrastructure.orm

import io.example.color.infrastructure.orm.ApplicationPropertyMapper
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesDynamicSqlSupport
import org.apache.ibatis.session.SqlSession
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

class PostgreSQLApplicationPropertyMapper : ApplicationPropertyMapper {
    private val ap = ApplicationPropertiesDynamicSqlSupport.ApplicationProperties

    override fun get(group: String, key: String): Pair<String, String> {
        val selectStatementProvider = select (
            ap.allColumns()
        ) {
            from(ap)
            where(ap.keyGroup, isEqualTo(group))
            and(ap.key, isEqualTo(key))
        }

        return "" to ""
    }
}