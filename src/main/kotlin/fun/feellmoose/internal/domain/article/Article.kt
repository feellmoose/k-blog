package `fun`.feellmoose.internal.domain.article

import java.time.LocalDateTime

data class Article(
    var id:Long? = null,
    var title: String,
    var description: String,
    var author:String,
    var html: String,
    var markdown: String,
    var createdTime: LocalDateTime,
    var modifiedTime: LocalDateTime,
    var path: String,
    var status: Status,
    var tags: List<String>
)





enum class Status{
    Publish, Prepare, Cancel
}
