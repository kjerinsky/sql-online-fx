package com.goyobo.sqlonline.ui.views

import com.goyobo.sqlonline.db.DbUtil
import com.goyobo.sqlonline.ui.MainStyles
import tornadofx.*

class IntoView : View() {
    override val root = vbox {
        addClass(MainStyles.view)
        label("Intro")
        button("Connect") {
            action {
                DbUtil.instance.test()
            }
        }
    }
}