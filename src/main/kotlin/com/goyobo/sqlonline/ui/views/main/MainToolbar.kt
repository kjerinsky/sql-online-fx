package com.goyobo.sqlonline.ui.views.main

import com.goyobo.sqlonline.utils.fontIcon
import com.goyobo.sqlonline.ui.MainStyles
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
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
                graphic = fontIcon(FontAwesomeIcon.FOLDER_OPEN_ALT)
                tooltip = Tooltip("Open")
            }
            button {
                graphic = fontIcon(FontAwesomeIcon.SAVE)
                tooltip = Tooltip("Save")
            }
        }
    }
}