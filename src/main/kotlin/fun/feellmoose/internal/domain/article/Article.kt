package `fun`.feellmoose.internal.domain.article

import `fun`.feellmoose.config.GlobalConfig
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
    var status: Status,
)

data class ArticlePage(
    var body: String
) {
    fun getInnerBody(): String = body.subSequence(6, body.length - 7).toString()
}

enum class Status {
    Publish, Prepare, Cancel
}

data class ArticleDescription(
    val url: String,
    val title: String,
    val description: String,
    val createdTime: LocalDateTime,
    val modifiedTime: LocalDateTime,
    val tags: List<String>,
) {
    companion object {
        fun of(article: Article): ArticleDescription {
            return ArticleDescription(
                url = GlobalConfig.BASE_URL + "/article/" + article.uuid,
                title = article.title,
                description = article.description,
                createdTime = article.createdTime,
                modifiedTime = article.modifiedTime,
                tags = article.tags,
            )
        }
    }
}