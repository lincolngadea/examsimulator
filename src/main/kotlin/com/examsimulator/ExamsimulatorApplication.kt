package com.examsimulator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExamsimulatorApplication

fun main(args: Array<String>) {
	runApplication<ExamsimulatorApplication>(*args)
}
