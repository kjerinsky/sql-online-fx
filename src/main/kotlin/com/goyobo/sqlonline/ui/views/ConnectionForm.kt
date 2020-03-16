package com.goyobo.sqlonline.ui.views

import com.goyobo.sqlonline.ui.models.SqlForm
import com.goyobo.sqlonline.utils.FileManager
import com.goyobo.sqlonline.utils.fontIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*

class ConnectionForm : View() {
    override val root = Form()

    private val sqlForm = SqlForm()

    init {
        with(root) {
            fieldset(
                "Database Connection",
                fontIcon(FontAwesomeIcon.DATABASE)
            ) {
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
                            bind(sqlForm.hostnameProperty)
                        }
                    }
                    field("Port") {
                        alignment = Pos.CENTER_RIGHT
                        textfield() {
                            maxWidth = 60.0
                            bind(sqlForm.portProperty)
                        }
                    }
                }
                field("username") {
                    textfield().bind(sqlForm.usernameProperty)
                }
                field("password") {
                    passwordfield().bind(sqlForm.passwordProperty)
                }
                button("Connect") {
                    vboxConstraints {
                        margin = insets(70, 5)
                    }
                    action {
//                        DbUtil.instance.test()
                        sqlForm.fromDTO(FileManager.loadFile())
                    }
                }
            }
        }
    }
}
