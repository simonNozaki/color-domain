package io.example.color.infrastructure.orm

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * マスターテーブルマッパーBean設定クラス
 */
@Configuration
class ApplicationPropertyMapperConfig {
    @Bean
    fun inMemoryApplicationPropertyMapper(): InMemoryApplicationPropertyMapper {
        return InMemoryApplicationPropertyMapper()
    }
}
