package io.example.color.worker.presentation.configuration

import io.example.color.worker.presentation.AddColorTasklet
import io.example.color.worker.presentation.OrderClothesTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * タスクレット設定クラス
 */
@Configuration
@EnableBatchProcessing
open class TaskletConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val addColorTasklet: AddColorTasklet,
    private val orderClothesTasklet: OrderClothesTasklet
) {
    /**
     * 加法混色タスクレットステップBean
     */
    private fun addColorTaskletStep(): Step {
        return this.stepBuilderFactory["addColorTasklet"]
            .tasklet(addColorTasklet)
            .build()
    }

    /**
     * 注文タスクレットステップ
     */
    private fun orderClothesTaskletStep(): Step {
        return this.stepBuilderFactory["orderClothesTasklet"]
            .tasklet(orderClothesTasklet)
            .build()
    }

    /**
     * ジョブ定義
     * ここでは全部のタスクレットをランダムに稼働
     */
    @Bean
    @Throws(Exception::class)
    open fun job(): Job {
        return jobBuilderFactory["colorDomainJob"]
            .listener(JobExecutionListener())
            .start(addColorTaskletStep())
            .next(orderClothesTaskletStep())
            .build()
    }
}
