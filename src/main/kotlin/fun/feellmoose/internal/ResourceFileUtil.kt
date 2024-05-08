package `fun`.feellmoose.internal

import io.ktor.utils.io.charsets.*
import java.io.File
import kotlin.text.Charsets

object ResourceFileUtil {
    private val classLoader = javaClass.classLoader

    fun getFile(name: String): File =
        File(classLoader.getResource(name)?.file ?: throw IllegalArgumentException("no such file $name"))

    fun readText(path: String, charSet: Charset = Charsets.UTF_8): String {
        return File(classLoader.getResource("markdown")?.file ?: "")
            .readText(charSet)
    }

    fun writeToFile(text: String, path: String, charSet: Charset = Charsets.UTF_8): File {
        return File(path).apply {
            createNewFile()
            writeText(text, charset = charSet)
        }
    }
}