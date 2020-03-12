package com.goyobo.sqlonline.ui

import com.goyobo.sqlonline.ui.views.IntoView
import tornadofx.View
import tornadofx.borderpane
import tornadofx.replaceWith

class MainView : View() {
    override val root = borderpane()

    init {
        title = "SQL Online"

        with (root) {
            prefWidth = 800.0
            prefHeight = 600.0

            left<Navigation>()
            center<IntoView>()
        }

        subscribe<NavigationChangeEvent> {
            root.center.replaceWith(it.view.root)
        }
    }
}
