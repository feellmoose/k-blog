package `fun`.feellmoose.pages.css

import kotlinx.css.*

object ResetCss : CssGenerator() {
    override fun generate(resource: Unit): String = css {
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
