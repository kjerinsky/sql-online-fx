package com.goyobo.sqlonline.ui

import javafx.scene.text.FontWeight
import tornadofx.*

class MainStyles : Stylesheet() {
    companion object {
        val navigation by cssclass()
        val view by cssclass()
        val navigationButton by cssclass()
    }

    init {
        navigation {
            backgroundColor += c("#0b4f6c")
            minWidth = 200.px
            spacing = 5.px
            padding = box(20.px, 10.px)
        }

        view {
            backgroundColor += c("#ddd")
        }

        navigationButton {
            backgroundColor += c(0.0,0.0,0.0,0.0)
            fontWeight = FontWeight.BOLD
            textFill = c("#ddd")
            fontSize = 16.px
        }
    }
}