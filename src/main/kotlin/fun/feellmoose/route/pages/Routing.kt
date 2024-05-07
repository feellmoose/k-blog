package `fun`.feellmoose.route.pages

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRoutingForPages() {
    routing {
        staticResources("/", "./static")

    }
}