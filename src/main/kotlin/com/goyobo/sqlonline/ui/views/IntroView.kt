package com.goyobo.sqlonline.ui.views

import tornadofx.View
import tornadofx.addClass
import tornadofx.plusAssign
import tornadofx.vbox

class IntoView : View() {
    private val connectionFrom : ConnectionForm by inject()

    override val root = vbox()

    init {
        with(root) {
            addClass(com.goyobo.sqlonline.ui.MainStyles.view)
            root += connectionFrom
        }
    }
}