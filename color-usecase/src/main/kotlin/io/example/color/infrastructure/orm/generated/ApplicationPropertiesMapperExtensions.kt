/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-10-24T16:09:03.901863+09:00
 */
package io.example.color.infrastructure.orm.generated

import io.example.color.infrastructure.orm.generated.ApplicationPropertiesDynamicSqlSupport.ApplicationProperties
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesDynamicSqlSupport.ApplicationProperties.description
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesDynamicSqlSupport.ApplicationProperties.key
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesDynamicSqlSupport.ApplicationProperties.keyGroup
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesDynamicSqlSupport.ApplicationProperties.value
import io.example.color.infrastructure.orm.generated.ApplicationPropertiesRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ApplicationPropertiesMapper.count(completer: CountCompleter) =
    countFrom(this::count, ApplicationProperties, completer)

fun ApplicationPropertiesMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, ApplicationProperties, completer)

fun ApplicationPropertiesMapper.deleteByPrimaryKey(keyGroup_: String, key_: String) =
    delete {
        where(keyGroup, isEqualTo(keyGroup_))
        and(key, isEqualTo(key_))
    }

fun ApplicationPropertiesMapper.insert(record: ApplicationPropertiesRecord) =
    insert(this::insert, record, ApplicationProperties) {
        map(keyGroup).toProperty("keyGroup")
        map(key).toProperty("key")
        map(value).toProperty("value")
        map(description).toProperty("description")
    }

fun ApplicationPropertiesMapper.insertMultiple(records: Collection<ApplicationPropertiesRecord>) =
    insertMultiple(this::insertMultiple, records, ApplicationProperties) {
        map(keyGroup).toProperty("keyGroup")
        map(key).toProperty("key")
        map(value).toProperty("value")
        map(description).toProperty("description")
    }

fun ApplicationPropertiesMapper.insertMultiple(vararg records: ApplicationPropertiesRecord) =
    insertMultiple(records.toList())

fun ApplicationPropertiesMapper.insertSelective(record: ApplicationPropertiesRecord) =
    insert(this::insert, record, ApplicationProperties) {
        map(keyGroup).toPropertyWhenPresent("keyGroup", record::keyGroup)
        map(key).toPropertyWhenPresent("key", record::key)
        map(value).toPropertyWhenPresent("value", record::value)
        map(description).toPropertyWhenPresent("description", record::description)
    }

private val columnList = listOf(keyGroup, key, value, description)

fun ApplicationPropertiesMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, ApplicationProperties, completer)

fun ApplicationPropertiesMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, ApplicationProperties, completer)

fun ApplicationPropertiesMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, ApplicationProperties, completer)

fun ApplicationPropertiesMapper.selectByPrimaryKey(keyGroup_: String, key_: String) =
    selectOne {
        where(keyGroup, isEqualTo(keyGroup_))
        and(key, isEqualTo(key_))
    }

fun ApplicationPropertiesMapper.update(completer: UpdateCompleter) =
    update(this::update, ApplicationProperties, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ApplicationPropertiesRecord) =
    apply {
        set(keyGroup).equalTo(record::keyGroup)
        set(key).equalTo(record::key)
        set(value).equalTo(record::value)
        set(description).equalTo(record::description)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ApplicationPropertiesRecord) =
    apply {
        set(keyGroup).equalToWhenPresent(record::keyGroup)
        set(key).equalToWhenPresent(record::key)
        set(value).equalToWhenPresent(record::value)
        set(description).equalToWhenPresent(record::description)
    }

fun ApplicationPropertiesMapper.updateByPrimaryKey(record: ApplicationPropertiesRecord) =
    update {
        set(value).equalTo(record::value)
        set(description).equalTo(record::description)
        where(keyGroup, isEqualTo(record::keyGroup))
        and(key, isEqualTo(record::key))
    }

fun ApplicationPropertiesMapper.updateByPrimaryKeySelective(record: ApplicationPropertiesRecord) =
    update {
        set(value).equalToWhenPresent(record::value)
        set(description).equalToWhenPresent(record::description)
        where(keyGroup, isEqualTo(record::keyGroup))
        and(key, isEqualTo(record::key))
    }