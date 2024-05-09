package `fun`.feellmoose.route.pages

import `fun`.feellmoose.internal.util.ResourceFileUtil
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRoutingForPages() {
    routing {
        staticFiles("/posts", ResourceFileUtil.getFile("static/posts"))
        staticFiles("/css", ResourceFileUtil.getFile("static/css"))
        staticFiles("/js", ResourceFileUtil.getFile("static/js"))
        staticFiles("/", ResourceFileUtil.getFile("static/home/index.html"))
    }
}