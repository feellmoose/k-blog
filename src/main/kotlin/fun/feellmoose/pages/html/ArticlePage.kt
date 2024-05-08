package `fun`.feellmoose.pages.html

import `fun`.feellmoose.internal.domain.article.Article
import `fun`.feellmoose.pages.css.*
import kotlinx.html.*
import java.time.format.DateTimeFormatter

object ArticlePage : PageGenerator<Article>() {

    val css = buildMap {
        put("article", ArticleCss)
        put("reset", ResetCss)
        put("fonts", FontCss)
        put("styles", StyleCss)
        put("darkMin", DarkMinCss)
    }

    override fun generate(resource: Article): String = html {
        head {
            meta { charset = "utf-8" }
            link(rel = "stylesheet", href = "/css/styles.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/fonts.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/article.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/reset.css", type = "text/css")
            link(rel = "stylesheet", href = "/css/dark-min.css", type = "text/css") {}
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
                        a(classes = "logo", href = "/logo") {
                            +"feellmoose's blog"
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
                    div(classes = "post-main") {
                        div(classes = "post-main-title") {
                            +resource.title
                        }
                        div(classes = "post-meta") {
                            +resource.createdTime.format(DateTimeFormatter.ISO_LOCAL_DATE)
                            +" ｜ "
                            +resource.tags.joinToString("  ")
                        }
                        div("article") {
                            unsafe {
                                +resource.page.getInnerBody()
                            }
                        }
                    }
                    div(classes = "footer") {
                        span { +"Copyright © 2023 feellmoose's blog" }
                    }

                    script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js") {}
                    script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlightjs-line-numbers.js/2.8.0/highlightjs-line-numbers.min.js") {}
                    script {
                        +"hljs.initHighlightingOnLoad();hljs.initLineNumbersOnLoad();"
                    }
                }
            }
        }
    }
}
