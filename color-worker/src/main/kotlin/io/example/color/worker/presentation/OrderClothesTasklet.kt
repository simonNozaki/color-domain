package io.example.color.worker.presentation

import io.example.color.presentation.dto.OrderClothesRequest
import io.example.color.usecase.OrderClothesUseCase
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

/**
 * 注文タスクレット
 */
@Component
open class OrderClothesTasklet(
    private val orderClothesUseCase: OrderClothesUseCase
) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        val req = OrderClothesRequest(
            44,
            "ffff00",
            "LOOSE",
            3
        )

        println("注文リクエスト => $req")
        val result = this.orderClothesUseCase.execute(req)

        println("注文処理終了")

        return RepeatStatus.FINISHED
    }
}
