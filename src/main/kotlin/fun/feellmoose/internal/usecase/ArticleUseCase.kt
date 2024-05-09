package `fun`.feellmoose.internal.usecase

import `fun`.feellmoose.config.BASE_URL
import `fun`.feellmoose.internal.domain.article.Article
import `fun`.feellmoose.internal.domain.article.ArticleGenerator
import `fun`.feellmoose.internal.util.ResourceFileUtil
import `fun`.feellmoose.pages.css.Css
import `fun`.feellmoose.pages.html.ArticlePage
import java.io.File
import java.util.*

object ArticleUseCase {

    fun refresh() : List<Article> {
        val articles = LinkedList<Article>()
        ResourceFileUtil.getFile("markdown").listFiles()?.forEach {
            articles += createOne(it)
        }
        refreshCss(ArticlePage.css)
        return articles
    }

    private fun createOne(file: File) : Article {
        val name = file.nameWithoutExtension
        val markdown = file.readText(Charsets.UTF_8)
        val article = ArticleGenerator.generate(markdown)
            .withLink("${BASE_URL}/posts/$name.html")
        ResourceFileUtil.writeToFile(ArticlePage.generate(article), "static/posts/$name.html")
        return article
    }

    private fun refreshCss(map: Map<String, Css>) {
        map.forEach { (k, v) ->
            ResourceFileUtil.writeToFile(v.generate(Unit), "static/css/$k.css")
        }
    }

}

