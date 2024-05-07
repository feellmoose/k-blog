package `fun`.feellmoose.internal.pages.html

import `fun`.feellmoose.internal.Generator
import `fun`.feellmoose.internal.domain.article.Article
import `fun`.feellmoose.internal.domain.article.ArticleGenerator
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.time.format.DateTimeFormatter

abstract class PageGenerator : Generator<Article, String>

fun html(block: HTML.() -> Unit): String = buildString {
    append("<!DOCTYPE html>\n")
    appendHTML().html(block = block)
}

object ArticlePageGenerator : PageGenerator() {
    override fun generate(resource: Article): String {
        return html {
            head {
                meta { charset = "utf-8" }
                link(rel = "stylesheet", href = "/styles.css", type = "text/css")
                link(rel = "stylesheet", href = "/fonts.css", type = "text/css")
                link(rel = "stylesheet", href = "/article.css", type = "text/css")
                link(rel = "stylesheet", href = "/reset.css", type = "text/css")
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
                link(rel = "stylesheet", href = "/dark-min.css", type = "text/css") {}
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
}
