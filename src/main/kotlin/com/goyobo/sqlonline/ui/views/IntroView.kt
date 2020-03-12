package com.goyobo.sqlonline.ui.views

import com.goyobo.sqlonline.ui.MainStyles
import tornadofx.View
import tornadofx.addClass
import tornadofx.label
import tornadofx.vbox

class IntoView : View() {
    override val root = vbox {
        addClass(MainStyles.view)
        label("Intro")
    }
}