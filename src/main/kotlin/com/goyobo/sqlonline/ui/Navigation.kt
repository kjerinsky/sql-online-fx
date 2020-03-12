package com.goyobo.sqlonline.ui

import com.goyobo.sqlonline.ui.views.IntoView
import com.goyobo.sqlonline.ui.views.Part1
import tornadofx.*

class Navigation : View() {
    override val root = vbox {
        addClass(MainStyles.navigation)

        button("Intro") {
            addClass(MainStyles.navigationButton)
            action {
                fire(NavigationChangeEvent(IntoView()))
            }
        }
        button("Part 1") {
            addClass(MainStyles.navigationButton)
            action {
                fire(NavigationChangeEvent(Part1()))
            }
        }
    }
}

class NavigationChangeEvent(val view: View) : FXEvent()