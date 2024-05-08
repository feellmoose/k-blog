package `fun`.feellmoose.pages.css

import kotlinx.css.*
import kotlinx.css.properties.*


object StyleCss : CssGenerator() {
    override fun generate(resource: Unit): String = css {
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