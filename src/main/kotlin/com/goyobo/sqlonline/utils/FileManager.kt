package com.goyobo.sqlonline.utils

import com.goyobo.sqlonline.ui.models.MainFormDto
import com.goyobo.sqlonline.ui.models.SqlForm
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.File

object FileManager {
    private val json = Json(JsonConfiguration.Stable)

    fun writeFile(form: SqlForm) {
        val jsonData = json.stringify(MainFormDto.serializer(), form.toDto())
        File("test.scfg").writeBytes(gzip(jsonData))
    }

    fun loadFile(): MainFormDto {
        val stream = File("test.scfg").inputStream()
        val compressedFile = stream.readBytes()
        stream.close()
        val jsonData = ungzip(compressedFile)
        return json.parse(MainFormDto.serializer(), jsonData)
    }
}
