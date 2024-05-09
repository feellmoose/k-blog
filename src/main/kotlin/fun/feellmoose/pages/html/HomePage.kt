package `fun`.feellmoose.pages.html

import `fun`.feellmoose.config.DESCRIPTION
import `fun`.feellmoose.config.SITE_NAME
import `fun`.feellmoose.config.TITLE
import `fun`.feellmoose.internal.domain.article.Article
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.meta
import kotlinx.html.title

object HomePage : Page<List<Article>>() {
    override fun generate(resource: List<Article>): String = CommonPageTemplate.generate(
        TemplateValue({
            meta(SITE_NAME)
            meta(DESCRIPTION)
            meta(TITLE)
            title("$TITLE - $DESCRIPTION")
        }, {
            div("post-list") {
                for (article in resource) {
                    div("post") {
                        a("post-title") {
                            href = article.link
                            +article.title
                        }
                        div("post-except") {
                            +article.description
                        }
                        div("post-date") {
                            +article.createdTime
                        }
                    }
                }
            }
        }, {
        })
    )
}