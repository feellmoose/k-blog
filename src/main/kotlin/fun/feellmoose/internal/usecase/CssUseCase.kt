package `fun`.feellmoose.internal.usecase

import `fun`.feellmoose.internal.ResourceFileUtil
import `fun`.feellmoose.internal.pages.css.*

object CssUseCase {

    private val map = buildMap {
        put("article", ArticleCssGenerator)
        put("reset", ResetCssGenerator)
        put("fonts", FontCssGenerator)
        put("styles", StyleCssGenerator)
        put("darkMin", DarkMinCssGenerator)
    }

    fun refresh() {
        val path = ResourceFileUtil.getFile("static/css").path
        map.forEach { (k, v) ->
            ResourceFileUtil.writeToFile(v.generate(Unit),"$path/$k.css")
        }
    }

}