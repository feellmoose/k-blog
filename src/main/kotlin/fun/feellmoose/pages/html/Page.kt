package `fun`.feellmoose.pages.html

import `fun`.feellmoose.internal.Generator
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

abstract class Page<R> : Generator<R, String>

data class TemplateValue(val head: HEAD.() -> Unit, val main: DIV.() -> Unit,val body: BODY.() -> Unit)

fun html(block: HTML.() -> Unit): String = buildString {
    append("<!DOCTYPE html>\n")
    appendHTML().html(block = block)
}
