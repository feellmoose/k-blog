package `fun`.feellmoose

import `fun`.feellmoose.config.configureSerialization
import `fun`.feellmoose.internal.usecase.ArticleUseCase
import `fun`.feellmoose.internal.usecase.CssUseCase
import `fun`.feellmoose.route.api.configureRoutingForApi
import `fun`.feellmoose.route.pages.configureRoutingForPages
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    ArticleUseCase.refresh()
    CssUseCase.refresh()
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRoutingForApi()
    configureRoutingForPages()
}
