package com.goyobo.sqlonline.utils

import com.goyobo.sqlonline.ui.models.SqlForm
import com.goyobo.sqlonline.ui.models.MainFormDto
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
        val compressedFile = File("test.scfg").inputStream().readBytes()
        val jsonData = ungzip(compressedFile)
        return json.parse(MainFormDto.serializer(), jsonData)
    }
}
