package com.goyobo.sqlonline

import tornadofx.*

class Navigation : View() {
    override val root = vbox {
        button("Intro") {
            action {
                fire(NavigationChangeEvent(IntoView()))
            }
        }
        button("Part 1") {
            action {
                fire(NavigationChangeEvent(Part1()))
            }
        }
    }
}

class NavigationChangeEvent(val screen: View) : FXEvent()