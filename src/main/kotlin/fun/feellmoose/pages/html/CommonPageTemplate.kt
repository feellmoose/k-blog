package `fun`.feellmoose.pages.html

import `fun`.feellmoose.config.SITE_NAME
import kotlinx.html.*

object CommonPageTemplate : Page<TemplateValue>() {
    override fun generate(resource: TemplateValue): String = html {
        head {
            meta(charset = "utf-8")
            let { resource.head.invoke(it) }
            link(rel = "stylesheet", href = "/css/styles.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/fonts.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/article.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/reset.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/dark-min.css", type = "text/css")
            link(rel = "preconnect", href = "https://fonts.googleapis.com")
            link(
                rel = "preconnect",
                href = "https://fonts.gstatic.com"
            )// <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            link(
                href = "https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap",
                rel = "stylesheet"
            )
            link(href = "https://fonts.gstatic.com", rel = "stylesheet")
        }
        body {
            div(classes = "paper") {
                div(classes = "paper-main") {
                    div(classes = "post-header") {
                        a(classes = "logo") {
                            +SITE_NAME
                        }
                        ul(classes = "nav") {
                            li(classes = "nav-item") {
                                a(href = "/") {
                                    +"Home"
                                }
                            }
                            li(classes = "nav-item") {
                                a(href = "/about") {
                                    +"About"
                                }
                            }
                            li(classes = "nav-item") {
                                a(href = "/archives") {
                                    +"Archives"
                                }
                            }
                        }
                    }
                    let{resource.main.invoke(it)}
                    div(classes = "footer") {
                        span { +"Copyright © 2023 $SITE_NAME" }
                    }
                }
            }
            let { resource.body.invoke(it) }
        }
    }
}