package io.example.color.infrastructure.orm

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

/**
 * 注文レコードマッパーBean設定クラス
 * Beanアノテーションでインスタンス定義してるからマッパー側にアノテーションは不要
 */
@Configuration
class OrderMapperBeanConfig {

    /**
     * PostgreSQL用マッパー実装
     */
    @Bean
    fun postgreSqlOrderMapper(): OrderMapper {
        return PostgreSQLOrderMapper()
    }

    /**
     * インメモリオブジェクト用マッパー実装、優先
     */
    @Bean
    @Primary
    fun inMemoryOrderMapper(): OrderMapper {
        return InMemoryOrderMapper()
    }
}
