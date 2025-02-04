package com.example.routes

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.getAllHeroes(){
   get("/boruto/heroes"){

       val heroRepository: HeroRepository by this@getAllHeroes.inject()

      try {
          val page = call.request.queryParameters["page"]?.toInt() ?: 1
          require( page in 1..5)

          val apiResponse = heroRepository.getAllHeroes(page = page)

          call.respond(
              message = apiResponse,
              status = HttpStatusCode.OK
          )

      }catch (e: NumberFormatException){
          call.respond(
              message = ApiResponse(success = false, message = "Only Number Allowed"),
              status = HttpStatusCode.BadRequest
          )
      } catch (e:IllegalArgumentException){
          call.respond(
              message = ApiResponse(success = false, message = "Heroes not found"),
              status = HttpStatusCode.NotFound
          )
      }
   }
}