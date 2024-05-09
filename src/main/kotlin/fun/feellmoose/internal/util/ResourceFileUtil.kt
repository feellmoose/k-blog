package `fun`.feellmoose.internal.util

import `fun`.feellmoose.config.FILE_PATH
import io.ktor.utils.io.charsets.*
import java.io.File
import kotlin.text.Charsets

object ResourceFileUtil {

    fun getFile(name: String): File =
        File("${FILE_PATH}/$name")

    fun readText(name: String, charSet: Charset = Charsets.UTF_8): String {
        return File("${FILE_PATH}/$name").readText(charset = charSet)
    }

    fun writeToFile(text: String, name: String, charSet: Charset = Charsets.UTF_8): File {
        return File("${FILE_PATH}/$name").apply {
            createNewFile()
            writeText(text, charset = charSet)
        }
    }
}