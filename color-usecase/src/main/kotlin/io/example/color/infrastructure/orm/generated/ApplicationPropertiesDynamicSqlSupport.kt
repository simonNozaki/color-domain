/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-10-24T16:09:03.895666+09:00
 */
package io.example.color.infrastructure.orm.generated

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object ApplicationPropertiesDynamicSqlSupport {
    object ApplicationProperties : SqlTable("public.application_properties") {
        val keyGroup = column<String>("key_group", JDBCType.VARCHAR)

        val key = column<String>("key", JDBCType.VARCHAR)

        val value = column<String>("value", JDBCType.VARCHAR)

        val description = column<String>("description", JDBCType.VARCHAR)
    }
}