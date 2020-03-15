package com.goyobo.sqlonline.ui.views

import com.goyobo.sqlonline.db.DbUtil
import com.goyobo.sqlonline.ui.models.ConnectionConfig
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*

class ConnectionForm : View() {
    override val root = Form()

    val connectionConfig = ConnectionConfig()

    init {
        with(root) {
            fieldset("Database Connection", FontAwesomeIconView(FontAwesomeIcon.DATABASE)) {
                field("Database") {
                    combobox<String> {
                        items = FXCollections.observableArrayList("MySQL")
                        disableProperty().set(true)
                        value = "MySQL"
                    }
                }
                hbox {
                    spacing = 15.0
                    field("Hostname") {
                        hgrow = Priority.ALWAYS
                        textfield() {
                            hgrow = Priority.ALWAYS
                            bind(connectionConfig.hostnameProperty)
                        }
                    }
                    field("Port") {
                        alignment = Pos.CENTER_RIGHT
                        textfield() {
                            maxWidth = 60.0
                            bind(connectionConfig.portProperty)
                        }
                    }
                }
                field("username") {
                    textfield().bind(connectionConfig.usernameProperty)
                }
                field("password") {
                    passwordfield().bind(connectionConfig.passwordProperty)
                }
                button("Connect") {
                    vboxConstraints {
                        margin = insets(70, 5)
                    }
                    action {
                        DbUtil.instance.test()
                    }
                }
            }
        }
    }
}
