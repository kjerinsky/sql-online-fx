package com.goyobo.sqlonline.ui.views.main

import com.goyobo.sqlonline.ui.MainStyles
import com.goyobo.sqlonline.utils.fontIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import javafx.scene.control.Tooltip
import tornadofx.View
import tornadofx.addClass
import tornadofx.button
import tornadofx.toolbar

class MainToolbar : View() {
    override val root = toolbar()

    init {
        with(root) {
            addClass(MainStyles.toolbarButtons)
            button {
                graphic = fontIcon(FontAwesomeIcon.FOLDER_OPEN)
                tooltip = Tooltip("Open")
            }
            button {
                graphic = fontIcon(MaterialDesignIcon.CONTENT_SAVE)
                tooltip = Tooltip("Save")
            }
        }
    }
}