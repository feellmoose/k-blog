package `fun`.feellmoose.pages.html

import `fun`.feellmoose.config.BASE_URL
import `fun`.feellmoose.internal.domain.article.Article
import `fun`.feellmoose.pages.css.*
import kotlinx.html.BASE
import kotlinx.html.div
import kotlinx.html.script
import kotlinx.html.unsafe
import java.time.format.DateTimeFormatter

object ArticlePage : Page<Article>() {

    val css = buildMap {
        put("article", ArticleCss)
        put("reset", ResetCss)
        put("fonts", FontCss)
        put("styles", StyleCss)
        put("dark-min", DarkMinCss)
    }

    override fun generate(resource: Article): String {
        return CommonPageTemplate.generate(
            TemplateValue({}, {
                div("post-main"){
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
            }, {
//                script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js") {}
//                script(src = "https://cdnjs.cloudflare.com/ajax/libs/highlightjs-line-numbers.js/2.8.0/highlightjs-line-numbers.min.js") {}
//                script(src = "$BASE_URL/js/trigger.js") {}
            })
        )
    }
}
