package io.example.color.infrastructure.orm

import io.example.color.infrastructure.orm.generated.ApplicationPropertiesMapper
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory

/**
 * SQLセッションファクトリオブジェクト
 */
object SqlSessionFactory {
    private const val JDBC_DRIVER = "org.postgresql.Driver"
    private const val JDBC_URL = "jdbc:postgresql://localhost:5432/color_domain_user"

    fun getSqlSessionFactory(): SqlSessionFactory {
        Class.forName("org.postgresql.Driver")

        val ds = UnpooledDataSource(
            JDBC_DRIVER,
            JDBC_URL,
            "color_domain_user",
            "color_domain_user"
        )
        val environment = Environment("test", JdbcTransactionFactory(), ds)
        val config = Configuration(environment)
        config.addMapper(ApplicationPropertiesMapper::class.java)
        return SqlSessionFactoryBuilder().build(config)
    }
}
