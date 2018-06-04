package design.kde.fundhub.common

import mu.KotlinLogging
import java.util.*

private val logger = KotlinLogging.logger {}
data class Response<out T>(val message: String, val data: T, val error: String = "") {
    fun logs(name: String): Response<T> {
        logger.info { "Response for $name: ${this.data}" }
        return this
    }
}

fun <T: Any> success(data: T): Response<T> = Response("success", data)

fun error(message: String) = Response("error", null, message)

fun <T: Any> respond(data: Optional<T>): Response<T> = data.map { success(it) }.orElse(error("not found"))
