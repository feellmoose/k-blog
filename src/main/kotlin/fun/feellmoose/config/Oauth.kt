package `fun`.feellmoose.config

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*

fun Application.configureOauth() {
    install(Authentication) {
        oauth("auth-oauth-github") {
            urlProvider = { "https://feellmoose.fun/api/oauth2/github" }
            providerLookup = {
                OAuthServerSettings.OAuth2ServerSettings(
                    name = "github",
                    authorizeUrl = "https://github.com/login/oauth/authorize",
                    accessTokenUrl = "https://github.com/login/oauth/access_token",
                    requestMethod = HttpMethod.Post,
                    clientId = System.getenv("GITHUB_CLIENT_ID"),
                    clientSecret = System.getenv("GITHUB_CLIENT_SECRET"),
                    defaultScopes = listOf("https://api.github.com/user"),

                    onStateCreated = { call, _ ->
                        call.request.queryParameters["redirectUrl"]?.let {
                            call.respondRedirect(it)
                        }
                    }
                )
            }
            client = httpClient
        }
    }

}

val httpClient = HttpClient(CIO)

