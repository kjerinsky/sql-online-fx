package com.goyobo.sqlonline.utils

import com.goyobo.sqlonline.ui.models.MainFormDto
import com.goyobo.sqlonline.ui.models.SqlForm
import javafx.stage.FileChooser
import javafx.stage.Window
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.File

object FileManager {
    private val json = Json(JsonConfiguration.Stable)
    private val extensionFilter = FileChooser.ExtensionFilter("SQL Online config", "*.scfg")
    private val dir = File(System.getProperty("user.dir"))

    fun writeConfig(owner: Window) {
        val chooser = FileChooser().apply {
            title = "Select a saved config"
            extensionFilters.add(extensionFilter)
            initialDirectory = dir
        }

        val file = chooser.showSaveDialog(owner)

        if (file != null) {
            val jsonData = json.stringify(MainFormDto.serializer(), SqlForm.instance.toDto())
            file.writeBytes(gzip(jsonData))
        }
    }

    fun openConfig(owner: Window) {
        val chooser = FileChooser().apply {
            title = "Select a saved config"
            extensionFilters.add(extensionFilter)
            initialDirectory = dir
        }

        val file = chooser.showOpenDialog(owner)

        if (file != null) {
            loadConfig(file)
        }
    }

    private fun loadConfig(file: File) {
        val stream = file.inputStream()
        val compressedFile = stream.readBytes()
        stream.close()

        val jsonData = ungzip(compressedFile)
        val dto = json.parse(MainFormDto.serializer(), jsonData)
        SqlForm.instance.fromDTO(dto)
    }
}
