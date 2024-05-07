import `fun`.feellmoose.internal.domain.article.ArticleGenerator
import `fun`.feellmoose.internal.pages.html.ArticlePageGenerator
import java.io.File

object ArticleUseCase {
    fun refresh() {
        val classLoader = javaClass.classLoader
        val root = File(classLoader.getResource("markdown")?.file ?: "").toPath().toFile()
        root.listFiles()?.forEach {
            createOne(it)
        }
    }

    private fun createOne(file: File) {
        val name = file.nameWithoutExtension
        val markdown = file.readText(Charsets.UTF_8)
        val path = "${file.parentFile.parentFile.path}/static/posts/$name.html"
        val html = File(path)
        html.createNewFile()
        val article = ArticleGenerator.generate(markdown)
        html.writeText(ArticlePageGenerator.generate(article), charset = Charsets.UTF_8)
    }
}

