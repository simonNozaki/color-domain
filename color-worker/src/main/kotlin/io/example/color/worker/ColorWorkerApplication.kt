package io.example.color.worker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    "io.example.color.worker.presentation",
    "io.example.color.domain",
    "io.example.color.infrastructure",
    "io.example.color.presentation",
    "io.example.color.usecase"
)
open class ColorWorkerApplication

fun main(args: Array<String>) {
    runApplication<ColorWorkerApplication>(*args)
}
