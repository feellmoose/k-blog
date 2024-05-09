package `fun`.feellmoose.pages.css

import kotlinx.css.*

object FontCss : Css() {
    override fun generate(resource: Unit): String = css {
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