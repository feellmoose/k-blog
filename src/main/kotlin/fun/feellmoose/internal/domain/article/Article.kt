package `fun`.feellmoose.internal.domain.article

import java.time.LocalDateTime

data class Article(
    val uuid: String,
    val title: String,
    val description: String,
    val author: String,
    val page: ArticlePage,
    val markdown: String,
    val createdTime: LocalDateTime,
    val tags: List<String>,
    var modifiedTime: LocalDateTime,
    var link: String = "",
    var status: Status,
) {
    fun withLink(link: String): Article {
        this.link = link
        return this
    }
}

data class ArticlePage(
    var body: String
) {
    fun getInnerBody(): String = body.subSequence(6, body.length - 7).toString()
}

enum class Status {
    Publish, Prepare, Cancel
}

data class ArticleDescription(
    val title: String,
    val description: String,
    val link: String,
    val createdTime: LocalDateTime,
    val modifiedTime: LocalDateTime,
    val tags: List<String>,
) {
    companion object {
        fun of(article: Article): ArticleDescription {
            return ArticleDescription(
                link = article.link,
                title = article.title,
                description = article.description,
                createdTime = article.createdTime,
                modifiedTime = article.modifiedTime,
                tags = article.tags,
            )
        }
    }
}