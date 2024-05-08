package `fun`.feellmoose.pages.css

import `fun`.feellmoose.internal.Generator
import kotlinx.css.CSSBuilder
import kotlinx.css.Color

abstract class CssGenerator : Generator<Unit, String>

inline fun css(builder: CSSBuilder.() -> Unit): String {
    return CSSBuilder().apply(builder).toString()
}

val fontColor0 = Color("#e00000")
val fontColor1 = Color("#252525")
val fontColor2 = Color("#333")
val fontColor3 = Color("#aaa")
val bgColor1 = Color("#eee")
val line1 = Color("#eee")
val line2 = Color(" #ddd")
