package com.goyobo.sqlonline.ui.models

import javafx.beans.property.SimpleStringProperty

class ConnectionConfig(port: String? = "3306") {
    val hostnameProperty = SimpleStringProperty()
    var hostname = hostnameProperty

    val portProperty = SimpleStringProperty(this, "port", port)
    var port = portProperty

    val usernameProperty = SimpleStringProperty()
    var username = usernameProperty

    val passwordProperty = SimpleStringProperty()
    var password = passwordProperty
}