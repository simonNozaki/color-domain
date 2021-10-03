package io.example.color.worker

import io.example.color.ColorApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    "io.example.color.worker.presentation"
)
class ColorWorkerApplication

fun main(args: Array<String>) {
    runApplication<ColorApplication>(*args)
}
