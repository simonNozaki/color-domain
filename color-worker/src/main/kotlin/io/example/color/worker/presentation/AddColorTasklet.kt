package io.example.color.worker.presentation

import io.example.color.presentation.dto.AddColorRequest
import io.example.color.usecase.AddColorUseCase
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

/**
 * 加法混色タスクレット実装クラス
 */
@Component
@StepScope
class AddColorTasklet (
    private val addColorUseCase: AddColorUseCase
    ) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {

        val req = AddColorRequest("ff0000", "00ff00")

        println("混色リクエスト: $req")
        val result = addColorUseCase.execute(req)
        println("混色結果: $result")

        return RepeatStatus.FINISHED
    }
}