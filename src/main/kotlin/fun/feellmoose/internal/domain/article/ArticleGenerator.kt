package `fun`.feellmoose.internal.domain.article

import `fun`.feellmoose.internal.Generator
import org.intellij.markdown.MarkdownElementTypes.LINK_DESTINATION
import org.intellij.markdown.MarkdownTokenTypes.Companion.CODE_FENCE_CONTENT
import org.intellij.markdown.MarkdownTokenTypes.Companion.TEXT
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.ast.getTextInNode
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.util.*

object ArticleGenerator : Generator<String, Article> {
    override fun generate(resource: String): Article {
        val articlePart = ArticlePartGenerator.generate(resource)
        val flavour = CommonMarkFlavourDescriptor()
        val root = MarkdownParser(flavour).buildMarkdownTreeFromString(articlePart.article)
        val body = HtmlGenerator(articlePart.article, root, flavour).generateHtml()
        val article = Article(
            uuid = UUID.randomUUID().toString(),
            title = getDescription(articlePart.description, "title:") ?: "",
            author = getDescription(articlePart.description, "author:") ?: "",
            tags = getDescription(articlePart.description, "tags:")?.split(",")?.toList() ?: emptyList(),
            markdown = resource,
            status = Status.Prepare,
            description = getDescription(articlePart.description, "description") ?: generateDescription(
                root,
                articlePart.article
            ),
            createdTime = getDescription(articlePart.description, "created-date:") ?: "",
            modifiedTime = getDescription(articlePart.description, "modified-date:") ?: "",
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
                    if (it.type == LINK_DESTINATION) return@forEach
                    if (it.type == TEXT) stringBuilder.append(it.getTextInNode(markdown));println(it.type)
                    if (it.type == CODE_FENCE_CONTENT) stringBuilder.append(it.getTextInNode(markdown))
                    else generateToString(it)
                }
            }
        }
        generateToString(root)
        return if (stringBuilder.length < max) stringBuilder.toString()
        else stringBuilder.substring(0, max).toString()
    }

    private fun getDescription(description: String, predix: String): String? =
        description.lines().find { it.startsWith(predix) }?.substring(predix.length)

}

data class ArticlePart(val description: String, val article: String)

object ArticlePartGenerator : Generator<String, ArticlePart> {
    override fun generate(resource: String): ArticlePart {
        val index = resource.indexOf("---", 4)
        return ArticlePart(resource.substring(4, index), resource.substring(index + 4))
    }
}

//class CustomMarkFlavourDescriptor : CommonMarkFlavourDescriptor() {
//    override fun createHtmlGeneratingProviders(linkMap: LinkMap, baseURI: URI?): Map<IElementType, GeneratingProvider> {
//        return super.createHtmlGeneratingProviders(linkMap, baseURI) + mapOf(
//
//        )
//    }
//}
