package `fun`.feellmoose.internal.util

import `fun`.feellmoose.config.GlobalConfig
import io.ktor.utils.io.charsets.*
import java.io.File
import kotlin.text.Charsets

object ResourceFileUtil {

    fun getFile(name: String): File =
        File("${GlobalConfig.FILE_PATH}/$name")

    fun readText(name: String, charSet: Charset = Charsets.UTF_8): String {
        return File("${GlobalConfig.FILE_PATH}/$name").readText(charset = charSet)
    }

    fun writeToFile(text: String, name: String, charSet: Charset = Charsets.UTF_8): File {
        return File("${GlobalConfig.FILE_PATH}/$name").apply {
            createNewFile()
            writeText(text, charset = charSet)
        }
    }
}