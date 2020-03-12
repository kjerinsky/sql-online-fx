package com.goyobo.sqlonline

import tornadofx.*

class Main: App(MainView::class)

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
            root.center.replaceWith(it.screen.root)
        }
    }
}

class IntoView : View() {
    override val root =  vbox {
        label("intro view")
    }
}

class Part1 : View() {
    override val root =  vbox {
        label("part 1 view")
    }
}


