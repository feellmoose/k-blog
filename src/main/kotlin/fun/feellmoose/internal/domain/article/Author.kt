package `fun`.feellmoose.internal.domain.article

import `fun`.feellmoose.internal.infrastructure.ArticleGenerator
import java.time.LocalDateTime

data class Author(
    var id: Long,
    var name: String
) {

    fun createArticle(
        markdown: String,
        title: String,
        createTime: LocalDateTime = LocalDateTime.now(),
        modifiedTime: LocalDateTime = LocalDateTime.now(),
        description: String? = null,
        tags: List<String>
    ): Article {
        val articleGenerator = ArticleGenerator(markdown)
        return Article(
            title = title,
            author = this.name,
            createdTime = createTime,
            modifiedTime = modifiedTime,
            markdown = markdown,
            description = description ?: articleGenerator.generateDescription(),
            html = articleGenerator.generateArticle(),
            path = "",
            status = Status.Prepare,
            tags = tags
        )
    }

    fun publishArticle(article: Article) {
        Status.Publish

    }

    fun updateArticle(article: Article) {
        article.modifiedTime = LocalDateTime.now()

    }

    fun cancelArticle(articleId: Long) {
        Status.Cancel
    }

    fun deleteArticle(articleId: Long) {

    }

}