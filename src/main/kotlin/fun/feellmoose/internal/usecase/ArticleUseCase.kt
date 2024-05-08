package `fun`.feellmoose.internal.usecase

import `fun`.feellmoose.config.GlobalConfig
import `fun`.feellmoose.internal.domain.article.ArticleGenerator
import `fun`.feellmoose.internal.util.ResourceFileUtil
import `fun`.feellmoose.pages.css.CssGenerator
import `fun`.feellmoose.pages.html.ArticlePage
import java.io.File

object ArticleUseCase {
    fun refresh() {
        ResourceFileUtil.getFile("markdown").listFiles()?.forEach {
            createOne(it)
        }
        refreshCss(ArticlePage.css)
    }

    private fun createOne(file: File) {
        val name = file.nameWithoutExtension
        val markdown = file.readText(Charsets.UTF_8)
        val article = ArticleGenerator.generate(markdown)
            .withLink("${GlobalConfig.BASE_URL}/posts/$name.html")
        ResourceFileUtil.writeToFile(ArticlePage.generate(article), "static/posts/$name.html")
    }

    private fun refreshCss(map: Map<String, CssGenerator>) {
        map.forEach { (k, v) ->
            ResourceFileUtil.writeToFile(v.generate(Unit), "static/css/$k.css")
        }
    }

}

