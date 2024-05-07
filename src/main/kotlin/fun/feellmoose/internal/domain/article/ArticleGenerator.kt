package `fun`.feellmoose.internal.domain.article

import `fun`.feellmoose.internal.Generator
import org.intellij.markdown.MarkdownTokenTypes.Companion.CODE_FENCE_CONTENT
import org.intellij.markdown.MarkdownTokenTypes.Companion.TEXT
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.ast.getTextInNode
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.time.LocalDateTime
import java.util.*

object ArticleGenerator : Generator<String, Article> {
    override fun generate(resource: String): Article {
        val flavour = CommonMarkFlavourDescriptor()
        val root = MarkdownParser(flavour).buildMarkdownTreeFromString(resource)
        val body = HtmlGenerator(resource, root, flavour).generateHtml()
        val article = Article(
            uuid = UUID.randomUUID().toString(),
            title = "",
            author = "",
            tags = emptyList(),
            markdown = resource,
            status = Status.Prepare,
            description = generateDescription(root,resource),
            createdTime = LocalDateTime.now(),
            modifiedTime = LocalDateTime.now(),
            page = ArticlePage(body),
        )
        return article
    }

    private fun generateDescription(root: ASTNode, markdown: String): String {
        return generateToString(root = root, markdown = markdown)
    }

    private fun generateToString(max: Int = 100, root: ASTNode, markdown: String): String {
        val stringBuilder = StringBuilder()
        fun generateToString(node: ASTNode) {
            if (stringBuilder.length < max) {
                node.children.forEach {
                    if (it.type == TEXT) stringBuilder.append(it.getTextInNode(markdown))
                    if (it.type == CODE_FENCE_CONTENT) stringBuilder.append(it.getTextInNode(markdown))
                    else generateToString(it)
                }
            }
        }
        generateToString(root)
        return if (stringBuilder.length < max) stringBuilder.toString()
        else stringBuilder.substring(0, max).toString()
    }
}
