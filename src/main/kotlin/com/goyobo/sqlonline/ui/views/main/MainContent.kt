package com.goyobo.sqlonline.ui.views.main

import com.goyobo.sqlonline.ui.MainStyles
import com.goyobo.sqlonline.ui.views.ConnectionForm
import tornadofx.View
import tornadofx.addClass
import tornadofx.plusAssign
import tornadofx.vbox

class MainContent : View() {
    private val connectionFrom : ConnectionForm by inject()

    override val root = vbox()

    init {
        with(root) {
            addClass(MainStyles.view)
            root += connectionFrom
        }
    }
}