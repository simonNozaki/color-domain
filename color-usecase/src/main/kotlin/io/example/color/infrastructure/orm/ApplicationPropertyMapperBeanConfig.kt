package io.example.color.infrastructure.orm

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

/**
 * マスターテーブルマッパーBean設定クラス
 */
@Configuration
class ApplicationPropertyMapperBeanConfig {
    @Bean
    fun inMemoryApplicationPropertyMapper(): InMemoryApplicationPropertyMapper {
        return InMemoryApplicationPropertyMapper()
    }

    @Bean
    @Primary
    fun postgreSQLApplicationPropertyMapper(): PostgreSQLApplicationPropertyMapper {
        return PostgreSQLApplicationPropertyMapper()
    }
}
