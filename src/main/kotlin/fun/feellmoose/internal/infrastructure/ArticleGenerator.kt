package `fun`.feellmoose.internal.infrastructure

import org.intellij.markdown.MarkdownTokenTypes.Companion.CODE_FENCE_CONTENT
import org.intellij.markdown.MarkdownTokenTypes.Companion.TEXT
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.ast.getTextInNode
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser

class ArticleGenerator(
    private val markdown: String,
    private val flavour: CommonMarkFlavourDescriptor = CommonMarkFlavourDescriptor(),
    private val root: ASTNode = MarkdownParser(flavour).buildMarkdownTreeFromString(markdown),
    private val body: String = HtmlGenerator(markdown, root, flavour).generateHtml(),
    private val inner: String = body.subSequence(6, body.length - 7).toString(),
) {
    fun generateArticle(): String {
        return inner
    }

    fun generateDescription(): String {
        return generateToString(100)
    }

    private fun generateToString(max: Int?): String {
        val stringBuilder = StringBuilder()
        fun generateToString(node: ASTNode) {
            if (max == null || stringBuilder.length < max) {
                node.children.forEach {
                    if (it.type == TEXT) stringBuilder.append(it.getTextInNode(markdown))
                    if (it.type == CODE_FENCE_CONTENT) stringBuilder.append(it.getTextInNode(markdown))
                    else generateToString(it)
                }
            }
        }
        generateToString(root)
        return if (max == null || stringBuilder.length < max) stringBuilder.toString()
        else stringBuilder.substring(0, max).toString()
    }
}