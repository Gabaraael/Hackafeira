package br.com.grpereira.scrat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScratApplication

fun main(args: Array<String>) {
	runApplication<ScratApplication>(*args)
}
