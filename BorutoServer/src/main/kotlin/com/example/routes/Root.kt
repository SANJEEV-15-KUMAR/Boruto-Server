package com.example.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get


fun Route.root(){
    get("/"){
       call.respond(
           message = "Welcome to Boruto API",
           status = HttpStatusCode.OK
       )
    }
}