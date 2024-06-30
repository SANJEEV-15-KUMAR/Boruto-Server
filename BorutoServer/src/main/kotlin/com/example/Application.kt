package com.example

import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>):Unit =
    io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureDefaultHeader() //not working properly its work is to load the image while server is not running
    configureStatusPages()
}
