package `fun`.feellmoose.internal.usecase

import `fun`.feellmoose.config.GlobalConfig
import `fun`.feellmoose.internal.ResourceFileUtil
import `fun`.feellmoose.internal.domain.article.ArticleGenerator
import `fun`.feellmoose.pages.html.ArticlePageGenerator
import java.io.File

object ArticleUseCase {
    fun refresh() {
        ResourceFileUtil.getFile("markdown").listFiles()?.forEach {
            createOne(it)
        }
    }

    private fun createOne(file: File) {
        val name = file.nameWithoutExtension
        val markdown = file.readText(Charsets.UTF_8)
        val path = "${file.parentFile.parentFile.path}/static/posts/$name.html"
        val article = ArticleGenerator.generate(markdown)
            .withLink("${GlobalConfig.BASE_URL}/posts/$name.html")
        ResourceFileUtil.writeToFile(ArticlePageGenerator.generate(article), path)
    }
}

