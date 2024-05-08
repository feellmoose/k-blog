package `fun`.feellmoose.internal.usecase

import `fun`.feellmoose.internal.ResourceFileUtil
import `fun`.feellmoose.pages.html.ArticlePageGenerator

object CssUseCase {

    private val map = buildMap {
        putAll(ArticlePageGenerator.css)
    }

    fun refresh() {
        val path = ResourceFileUtil.getFile("static/css").path
        map.forEach { (k, v) ->
            ResourceFileUtil.writeToFile(v.generate(Unit), "$path/$k.css")
        }
    }

}