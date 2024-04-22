package com.porek

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.porek"])
class PlaceholderApp

fun main(args: Array<String>) {
	printMemoryUsage()
	runApplication<PlaceholderApp>(*args)
}

val Long.mb: Long
	get() = this / (1024 * 1024)

fun printMemoryUsage() {
	val runtime = Runtime.getRuntime()

	val maxMemory: Long = runtime.maxMemory()
	val allocatedMemory: Long = runtime.totalMemory()
	val freeMemory: Long = runtime.freeMemory()

	println(
		"""
           ========================== Memory Info ==========================
           Free memory: ${freeMemory.mb}mb
           Allocated memory: ${allocatedMemory.mb}mb
           Max memory: ${maxMemory.mb}mb
           Total free memory: ${(freeMemory + (maxMemory - allocatedMemory)).mb}mb
           =================================================================""".trimIndent()
	)
}
