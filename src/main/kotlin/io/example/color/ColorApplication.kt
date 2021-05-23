package io.example.color

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

/**
 * アプリケーションブートストラップクラス
 */
@SpringBootApplication
@ComponentScan(
	"io.example.color.domain",
	"io.example.color.infrastructure",
	"io.example.color.presentation",
	"io.example.color.usecase"
)
class ColorApplication

fun main(args: Array<String>) {
	runApplication<ColorApplication>(*args)
}
