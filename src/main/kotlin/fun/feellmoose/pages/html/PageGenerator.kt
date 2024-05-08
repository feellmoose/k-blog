package `fun`.feellmoose.pages.html

import `fun`.feellmoose.internal.Generator
import kotlinx.html.HTML
import kotlinx.html.html
import kotlinx.html.stream.appendHTML

abstract class PageGenerator<R> : Generator<R, String>

fun html(block: HTML.() -> Unit): String = buildString {
    append("<!DOCTYPE html>\n")
    appendHTML().html(block = block)
}

