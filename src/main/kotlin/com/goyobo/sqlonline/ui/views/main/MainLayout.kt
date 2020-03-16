package com.goyobo.sqlonline.ui.views.main

import tornadofx.View
import tornadofx.borderpane

class MainLayout : View() {
    override val root = borderpane()

    init {
        title = "SQL Online"

        with (root) {
            prefWidth = 800.0
            prefHeight = 600.0

            top<MainToolbar>()
            left<Navigation>()
            center<MainContent>()
        }

//        subscribe<NavigationChangeEvent> {
//            root.center.replaceWith(it.view.root)
//        }
    }
}
