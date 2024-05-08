package `fun`.feellmoose.pages.css

import kotlinx.css.*


object DarkMinCss : CssGenerator() {
    override fun generate(resource: Unit): String = css {
        rule("pre code.hljs") {
            display = Display.block
            overflowX = Overflow.auto
            padding = "1em"
        }
        rule("code.hljs") {
            padding = "3px 5px"
        }
        rule(".hljs") {
            background = "#2b2b2b"
            color = Color("#f8f8f2")
        }
        rule(".hljs-comment,.hljs-quote") {
            color = Color("#d4d0ab")
        }
        rule(".hljs-deletion,.hljs-name,.hljs-regexp,.hljs-selector-class,.hljs-selector-id,.hljs-tag,.hljs-template-variable,.hljs-variable") {
            color = Color("#ffa07a")
        }
        rule(".hljs-built_in,.hljs-link,.hljs-literal,.hljs-meta,.hljs-number,.hljs-params,.hljs-type") {
            color = Color("#f5ab35")
        }
        rule(".hljs-attribute") {
            color = Color.gold
        }
        rule(".hljs-addition,.hljs-bullet,.hljs-string,.hljs-symbol") {
            color = Color("#abe338")
        }
        rule(".hljs-section,.hljs-title") {
            color = Color("#00e0e0")
        }
        rule(".hljs-keyword,.hljs-selector-tag") {
            color = Color("#dcc6e0")
        }
        rule(".hljs-emphasis") {
            fontStyle = FontStyle.italic
        }
        rule(".hljs-strong") {
            fontWeight = FontWeight("700")
        }
        media("screen and (-ms-high-contrast:active)") {
            rule(".hljs-addition,.hljs-attribute,.hljs-built_in,.hljs-bullet,.hljs-comment,.hljs-link,.hljs-literal,.hljs-meta,.hljs-number,.hljs-params,.hljs-quote,.hljs-string,.hljs-symbol,.hljs-type") {
                color = Color("highlight")//color:highlight;
            }
            rule(".hljs-keyword,.hljs-selector-tag") {
                fontWeight = FontWeight("700")
            }
        }
    }

}