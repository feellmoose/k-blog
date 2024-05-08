package `fun`.feellmoose.pages.css

import kotlinx.css.*
import kotlinx.css.properties.*


object ArticleCss : CssGenerator() {
    override fun generate(resource: Unit): String = css {
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
        rule(".article .video-container") {
            background = "#000"
            borderRadius = 4.px
            overflow = Overflow.hidden
        }
        rule(".article iframe,.article .video-container iframe") {
            width = 100.pct
            height = 100.vh
            maxHeight = 360.px
            margin = "12px 0"
        }
        rule(".article img") {
            borderRadius = 4.px
            boxSizing = BoxSizing.borderBox
            padding = "5px 5px"
            border = "1px solid #ebebeb"
        }
        rule(".article hr") {
            border = "none"
            height = 1.px
            background = line1.toString()
            margin = "24px 0"
        }
        rule(".article p,.article blockquote") {
            width = 100.pct
            margin = "12px 0"
        }
        rule(".article blockquote") {
            borderLeft = "2px solid $line2"
            paddingLeft = 12.px
            wordWrap = WordWrap.breakWord
            margin = "12px 0"
        }
        rule(".article>table") {
            width = 100.pct
            textAlign = TextAlign.left
            borderSpacing = LinearDimension("0")
        }
        rule(".article>table th") {
            padding = "12px 0";
            borderBottom = "2px solid $line1"
        }
        rule(".article>table tr:nth-child(odd) td") {
            padding = "12px 0";
            borderBottom = "1px solid $line1"
            background = "#fafafa"
        }
        rule(".article>table tr:nth-child(even) td") {
            padding = "12px 0";
            borderBottom = "1px solid $line1"
            background = "#fff"
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
