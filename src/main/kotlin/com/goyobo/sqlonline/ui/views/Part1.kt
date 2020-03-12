package com.goyobo.sqlonline.ui.views

import com.goyobo.sqlonline.ui.MainStyles
import tornadofx.View
import tornadofx.addClass
import tornadofx.label
import tornadofx.vbox

class Part1 : View() {
    override val root = vbox {
        addClass(MainStyles.view)
        label("Part1")
    }
}