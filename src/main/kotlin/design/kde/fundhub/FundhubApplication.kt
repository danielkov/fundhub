package design.kde.fundhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FundhubApplication

fun main(args: Array<String>) {
    runApplication<FundhubApplication>(*args)
}
