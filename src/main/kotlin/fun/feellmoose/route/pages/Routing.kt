package `fun`.feellmoose.route.pages

import `fun`.feellmoose.internal.api.Api
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.*
import java.time.format.DateTimeFormatter

fun Application.configureRoutingForPages() {
    val fontColor0 = Color("#e00000")
    val fontColor1 = Color("#252525")
    val fontColor2 = Color("#333")
    val fontColor3 = Color("#aaa")
    val bgColor1 = Color("#eee")
    val line1 = Color("#eee")
    val line2 = Color(" #ddd")
    routing {
        get("/article.css") {
            call.respondCss {
                rule(".article") {
                    width = 100.pct
                    fontSize = 16.px
                    letterSpacing = LinearDimension("0")
                }
                rule(".article h1,h2,h3,h4,h5,h6") {
                    color = fontColor1
                    margin = "12px 0"
                }
                rule(".article h1") {
                    fontSize = 2.rem
                    lineHeight = LineHeight("1.2")
                    padding = "24px 0"
                }
                rule(".article h2") {
                    fontSize = 1.6.rem
                    lineHeight = LineHeight("1.2")
                    padding = "20px 0"
                }
                rule(".article h3") {
                    fontSize = 1.4.rem
                    lineHeight = LineHeight("1.2")
                    padding = "18px 0"
                }
                rule(".article h4") {
                    fontSize = 1.2.rem
                    lineHeight = LineHeight("1.2")
                    padding = "16px 0"
                }
                rule(".article h5") {
                    fontSize = 1.15.rem
                    lineHeight = LineHeight("1.2")
                    padding = "14px 0"
                }
                rule(".article h6") {
                    fontSize = 1.1.rem
                    lineHeight = LineHeight("1.2")
                    padding = "12px 0"
                }
                rule(".article a") {
                    color = fontColor0
                    transition(property = "color", duration = .65.s, timing = Timing.easeInOut)
                    transition(property = "box-shadow", duration = .65.s, timing = Timing.easeInOut)
                }
                rule(".article a:hover") {
                    color = fontColor0
                    boxShadow(
                        color = fontColor0,
                        offsetX = 0.px,
                        offsetY = 2.px,
                        blurRadius = 0.px,
                        spreadRadius = 0.px
                    )
                    transition(property = "color", duration = .65.s, timing = Timing.easeInOut)
                    transition(property = "box-shadow", duration = .65.s, timing = Timing.easeInOut)
                }
                rule(".article strong") {
                    fontWeight = FontWeight("700")
                }
                rule(".article em") {
                    fontStyle = FontStyle.italic
                }
                rule(".article kbd") {
                    padding = "2px 4px"
                    borderRadius = 2.px
                    background = "#eee"
                    border = "1px solid #ddd"
                }
                rule(".article ol") {
                    listStyleType = ListStyleType.decimal
                    paddingLeft = 24.px
                }
                rule(".article ul") {
                    listStyleType = ListStyleType.disc
                    paddingLeft = 24.px
                }
                rule(".article .video-container"){
                    background = "#000"
                    borderRadius = 4.px
                    overflow = Overflow.hidden
                }
                rule(".article iframe,.article .video-container iframe"){
                    width = 100.pct
                    height = 100.vh
                    maxHeight = 360.px
                    margin = "12px 0"
                }
                rule(".article img"){
                    borderRadius = 4.px
                    boxSizing = BoxSizing.borderBox
                    padding = "5px 5px"
                    border = "1px solid #ebebeb"
                }
                rule(".article hr"){
                    border = "none"
                    height = 1.px
                    background = line1.toString()
                    margin = "24px 0"
                }
                rule(".article p,.article blockquote"){
                   width = 100.pct
                    margin = "12px 0"
                }
                rule(".article blockquote"){
                    borderLeft = "2px solid $line2"
                    paddingLeft = 12.px
                    wordWrap = WordWrap.breakWord
                    margin = "12px 0"
                }
                rule(".article>table"){
                    width =  100.pct
                    textAlign = TextAlign.left
                    borderSpacing = LinearDimension("0")
                }
                rule(".article>table th"){
                    padding  = "12px 0";
                    borderBottom = "2px solid $line1"
                }
                rule(".article>table tr:nth-child(odd) td"){
                    padding  = "12px 0";
                    borderBottom = "1px solid $line1"
                    background =  "#fafafa"
                }
                rule(".article>table tr:nth-child(even) td"){
                    padding  = "12px 0";
                    borderBottom = "1px solid $line1"
                    background =  "#fff"
                }
                rule(".article code") {
                    borderRadius = 4.px
                    background = "#2b2b2b"
                    padding = "2px 4px"
                    color = Color("#f8f8f2")
                    fontSize = 1.rem
                }
                rule(".article .hljs-ln-numbers") {
                    opacity = .5
                    paddingRight = 12.px
                }


            }
        }



        get("/styles.css") {
            call.respondCss {
                p {
                    wordWrap = WordWrap.breakWord
                    whiteSpace = WhiteSpace.preWrap
                }
                body {
                    fontFamily =
                        "\"Montserrat\", \"SF UI Text\", \"PingFang SC\", \"Hiragino Sans GB\", \"Microsoft YaHei\", \"Segoe UI\", \"Helvetica Neue\", Helvetica, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\", sans-serif"
                    fontSize = 16.px
                    lineHeight = LineHeight("1.75")
                    letterSpacing = 0.6.px;
                    color = fontColor2
                }
                a {
                    textDecoration = TextDecoration.none
                    color = fontColor3
                }
                rule(".paper") {
                    width = 100.pct
                    maxWidth = 1100.px
                    margin = "0px auto"
                    padding = "72px 8vw 24px"
                    background = "#fff"
                    borderRadius = 24.px
                }
                rule(".header") {
                    paddingBottom = 48.px
                    marginBottom = 48.px
                    borderBottom = "1px solid $line1"
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.flexStart
                    alignContent = Align.center
                }
                rule(".logo") {
                    fontSize = 2.rem
                    fontWeight = FontWeight("600")
                    color = fontColor1
                    marginBottom = 23.px
                    flex(0.0, 0.0, 100.pct)
                }
                rule(".nav") {
                    margin = "0 0 4px"
                    flex(0.0, 0.0, 100.pct)
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.flexStart
                    alignContent = Align.center
                }
                rule(".nav li") {
                    padding = "2px 0"
                    marginRight = 24.px
                }
                rule(".nav li:last-of-type") {
                    marginRight = LinearDimension("0")
                }
                rule(".nav li a") {
                    color = fontColor1
                    opacity = .7
                    transition(property = "opacity", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".nav li a:hover") {
                    opacity = 1
                    transition(property = "opacity", timing = Timing.easeInOut, duration = .5.s)
                }


                //header
                rule(".post-header") {
                    marginBottom = LinearDimension("48px")
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.flexStart
                    alignContent = Align.center
                }
                rule(".post-header .logo") {
                    fontSize = 2.rem
                }
                rule(".post-header .go-home") {
                    display = Display.block
                    padding(10.px, 20.px, 8.px)
                    borderRadius = 18.px
                    background = "#fff"
                    border = "1px solid #eee"
                    margin(8.px, LinearDimension("0"))
                    transition(property = "background", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".post-header .go-home:hover") {
                    background = bgColor1.toString()
                    transition(property = "background", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".post-header .go-home svg") {
                    transform {
                        translateX(LinearDimension("0"))
                    }
                    transition(property = "background", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".post-header .go-home:hover svg") {
                    transform {
                        translateX((-4).px)
                    }
                    transition(property = "background", timing = Timing.easeInOut, duration = .5.s)
                }


                rule(".post-list") {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.flexStart
                    alignItems = Align.stretch
                }
                rule(".post") {
                    width = 100.pct
                    paddingBottom = 48.px
                    marginBottom = 48.px
                    border = "1px dashed $line2"
                }
                rule(".post-title") {
                    display = Display.inlineBlock
                    fontSize = 1.6.rem
                    fontWeight = FontWeight("600")
                    lineHeight = LineHeight("1.5em")
                    marginBottom = 12.px
                    color = fontColor1
                }
                rule(".post-title:hover") {
                    color = fontColor0
                    transition(property = "color", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".post-except") {
                    wordBreak = WordBreak.breakAll
                    marginBottom = 12.px
                }
                rule(".post-date") {
                    fontSize = 0.875.rem
                    color = fontColor3
                }

                //read-more
                rule(".read-more") {
                    padding(LinearDimension("0"), LinearDimension("4px"))
                    color = fontColor0
                }
                rule(".read-more:before") {
                    display = Display.inlineBlock
                    transition(property = "transform", timing = Timing.easeInOut, duration = .5.s)
                    content = QuotedString("{ ")
                }
                rule(".read-more:after") {
                    display = Display.inlineBlock
                    transition(property = "transform", timing = Timing.easeInOut, duration = .5.s)
                    content = QuotedString(" }")
                }
                rule(".read-more:hover:before") {
                    transform {
                        translateX((-4).px)
                    }
                    transition(property = "transform", timing = Timing.easeInOut, duration = .25.s)
                }
                rule(".read-more:hover:after") {
                    transform {
                        translateX(4.px)
                    }
                    transition(property = "transform", timing = Timing.easeInOut, duration = .25.s)
                }

                //footer
                rule(".footer") {
                    padding = "24px 0"
                    fontSize = 0.875.rem
                    color = fontColor3
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    flexWrap = FlexWrap.nowrap
                    justifyContent = JustifyContent.flexStart
                    alignContent = Align.center
                }
                rule(".footer span") {
                    textAlign = TextAlign.center
                    marginBottom = 8.px
                }
                rule(".footer a") {
                    color = fontColor3
                    transition(property = "color", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".footer a:hover") {
                    color = fontColor0
                    transition(property = "color", timing = Timing.easeInOut, duration = .5.s)
                }


                //page
                rule(".paginator") {
                    fontSize = 0.875.rem
                    width = 100.pct
                    margin(LinearDimension("0"), LinearDimension.auto, 24.px)
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.center
                    alignItems = Align.center
                }
                rule(".paginator *") {
                    display = Display.block
                    padding(8.px, 16.px)
                    borderRadius = 18.px
                    background = "#fff"
                    border = "1px solid #eee"
                }
                rule(".paginator .space") {
                    display = Display.block
                    padding(8.px, 16.px)
                    borderRadius = 18.px
                    background = "#fff"
                    border = "none"
                }
                rule(".paginator a") {
                    margin(4.px)
                    color = fontColor2
                    transition(property = "color", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".paginator a:hover") {
                    color = fontColor0
                    transition(property = "color", timing = Timing.easeInOut, duration = .5.s)
                }
                rule(".paginator .current") {
                    color = fontColor0
                    border = "1px solid $fontColor0"
                }

                //tags
                rule(".tags") {
                    marginBottom = 32.px
                }
                rule(".tags a") {
                    display = Display.inlineBlock
                    boxSizing = BoxSizing.borderBox
                    padding = "0 1em"
                    height = 28.px
                    borderRadius = 28.px
                    backgroundColor = Color.black
                    color = Color.white
                    textDecoration = TextDecoration.none
                }
                rule(".tags a") {
                    display = Display.inlineBlock
                    boxSizing = BoxSizing.borderBox
                    padding = "0 1.em"
                    height = 28.px
                    borderRadius = 28.px
                    backgroundColor = Color.black
                    color = Color.white
                    textDecoration = TextDecoration.none
                }
                rule(".tags a+a") {
                    marginLeft = .2.em
                }
                rule(".tags .new") {
                    color = Color.white
                }
                rule(".tags .update") {
                    color = Color.white
                }

                //main
                rule(".post-main") {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.flexStart
                    alignItems = Align.center
                    marginBottom = 24.px
                }
                rule(".post-main-title") {
                    flex(0.0, 0.0, 100.pct)
                    marginBottom = 12.px
                    fontSize = 1.6.rem
                    fontWeight = FontWeight("600")
                    lineHeight = LineHeight("1.5em")
                    color = fontColor1
                }
                rule(".post-meta") {
                    fontSize = 0.875.rem
                    color = fontColor3
                    flex(0.0, 0.0, 100.pct)
                    marginBottom = 15.px
                }
                rule(".archive") {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.spaceBetween
                    //align-content: normal;
                }
                rule(".archive li") {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    flexWrap = FlexWrap.nowrap
                    justifyContent = JustifyContent.flexStart
                    alignContent = Align.center
                    padding(12.px, LinearDimension("0"))
                }
                rule(".archive li:nth-child(odd)") {
                    background = "#fafafa"
                }
                rule(".archive li:nth-child(even)") {
                    background = "#fff"
                }
                rule(".archive li span") {
                    width = 108.px
                    color = fontColor2
                }
                rule(".archive-main") {
                    flex(0.0, 1.0, FlexBasis("calc(100% - 108px)"))
                }
                rule(".archive-title") {
                    color = fontColor1
                }
                rule(".archive-title:hover") {
                    color = fontColor0
                    transition(property = "color", timing = Timing.easeInOut, duration = .5.s)
                }

            }
        }

        get("/fonts.css") {
            call.respondCss {
                fontFace {
                    fontFamily = "\"Montserrat\", sans-serif"
                    fontStyle = FontStyle.normal
                    fontWeight = FontWeight("400")
                }
                fontFace {
                    fontFamily = "\"Montserrat\", sans-serif"
                    fontStyle = FontStyle.normal
                    fontWeight = FontWeight("600")
                }
                fontFace {
                    fontFamily = "\"Montserrat\", sans-serif"
                    fontStyle = FontStyle.italic
                    fontWeight = FontWeight("400")
                }
                fontFace {
                    fontFamily = "\"Montserrat\", sans-serif"
                    fontStyle = FontStyle.italic
                    fontWeight = FontWeight("600")
                }
            }
        }

        get("/dark-min.css"){
            call.respondCss {
                rule("pre code.hljs"){
                    display = Display.block
                    overflowX = Overflow.auto
                    padding = "1em"
                }
                rule("code.hljs"){
                    padding = "3px 5px"
                }
                rule(".hljs"){
                    background = "#2b2b2b"
                    color = Color("#f8f8f2")
                }
                rule(".hljs-comment,.hljs-quote"){
                    color = Color("#d4d0ab")
                }
                rule(".hljs-deletion,.hljs-name,.hljs-regexp,.hljs-selector-class,.hljs-selector-id,.hljs-tag,.hljs-template-variable,.hljs-variable"){
                    color = Color("#ffa07a")
                }
                rule(".hljs-built_in,.hljs-link,.hljs-literal,.hljs-meta,.hljs-number,.hljs-params,.hljs-type"){
                    color = Color("#f5ab35")
                }
                rule(".hljs-attribute"){
                    color = Color.gold
                }
                rule(".hljs-addition,.hljs-bullet,.hljs-string,.hljs-symbol"){
                    color = Color("#abe338")
                }
                rule(".hljs-section,.hljs-title"){
                    color = Color("#00e0e0")
                }
                rule(".hljs-keyword,.hljs-selector-tag"){
                    color = Color("#dcc6e0")
                }
                rule(".hljs-emphasis"){
                    fontStyle = FontStyle.italic
                }
                rule(".hljs-strong"){
                    fontWeight = FontWeight("700")
                }
                media("screen and (-ms-high-contrast:active)"){
                    rule(".hljs-addition,.hljs-attribute,.hljs-built_in,.hljs-bullet,.hljs-comment,.hljs-link,.hljs-literal,.hljs-meta,.hljs-number,.hljs-params,.hljs-quote,.hljs-string,.hljs-symbol,.hljs-type"){
                        color = Color("highlight")//color:highlight;
                    }
                    rule(".hljs-keyword,.hljs-selector-tag"){
                        fontWeight = FontWeight("700")
                    }
                }
            }
        }

        get("/reset.css") {
            call.respondCss {
                rule("*,*::before,*::after") {
                    boxSizing = BoxSizing.borderBox
                }
                rule("body,h1,h2,h3,h4,h5,h6,p,figure,blockquote,dl,dd") {
                    margin = "0"
                }
                rule("ul,ol") {
                    listStyleType = ListStyleType.none
                }
                rule("ul") {
                    paddingLeft = LinearDimension("0")
                    //padding-inline-start: 0;
                }
                rule("html,body") {
                    scrollBehavior = ScrollBehavior.smooth
                }
                rule("a:not([class])") {
                    //text-decoration-skip-ink: auto;
                }
                rule("img,picture") {
                    width = LinearDimension.auto
                    maxWidth = 100.pct
                    display = Display.block
                }
                rule("input,button,textarea,select") {
                    fontStyle = FontStyle.inherit
                    fontWeight = FontWeight.inherit
                    fontSize = LinearDimension.inherit
                    //font: inherit;
                }
                media("prefers-reduced-motion: reduce") {
                    //@media (prefers-reduced-motion: reduce)
                    focusWithin {
                        scrollBehavior = ScrollBehavior.auto
                    }
                }
            }
        }


        get("/article/{articleId}") {
            call.respondHtml {
                head {
                    meta { charset = "utf-8" }
                    link(rel = "stylesheet", href = "/styles.css", type = "text/css")
                    link(rel = "stylesheet", href = "/fonts.css", type = "text/css")
                    link(rel = "stylesheet", href = "/article.css", type = "text/css")
                    link(rel = "stylesheet", href = "/reset.css", type = "text/css")
                    link(rel="preconnect" ,href="https://fonts.googleapis.com")
                    link(rel="preconnect" ,href="https://fonts.gstatic.com")// <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    link(href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap", rel="stylesheet")
                    link(href="https://fonts.gstatic.com", rel="stylesheet")
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
                                        a(href = "/"){
                                            +"Home"
                                        }
                                    }
                                    li(classes = "nav-item") {
                                        a(href = "/about"){
                                            +"About"
                                        }
                                    }
                                    li(classes = "nav-item") {
                                        a(href = "/archives"){
                                            +"Archives"
                                        }
                                    }
                                }
                            }
                            div(classes = "post-main") {

                                val article = Api.articleOfId(call.parameters["articleId"]?.toLong())
                                div(classes = "post-main-title") {
                                    +article.title
                                }
                                div(classes = "post-meta") {
                                    +article.createdTime.format(DateTimeFormatter.ISO_LOCAL_DATE)
                                    +" ｜ "
                                    +article.tags.joinToString("  ")
                                }
                                div("article") {
                                    unsafe {
                                        +article.html
                                    }
                                }
                            }
                            div(classes = "footer") {
                                span { +"Copyright © 2023 feellmoose's blog" }
                            }

                            script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"){}
                            script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlightjs-line-numbers.js/2.8.0/highlightjs-line-numbers.min.js"){}
                            script {
                                +"hljs.initHighlightingOnLoad();hljs.initLineNumbersOnLoad();"
                            }
                        }
                    }
                }
            }
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}