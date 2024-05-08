package `fun`.feellmoose.route.pages

import `fun`.feellmoose.config.GlobalConfig
import `fun`.feellmoose.internal.util.ResourceFileUtil
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRoutingForPages() {
    routing {
        staticFiles("/", ResourceFileUtil.getFile("static"))
    }
}