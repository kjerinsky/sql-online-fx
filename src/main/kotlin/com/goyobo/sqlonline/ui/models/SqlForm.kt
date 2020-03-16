package com.goyobo.sqlonline.ui.models

import com.goyobo.sqlonline.utils.Encryptor
import javafx.beans.property.SimpleStringProperty
import kotlinx.serialization.Serializable

class SqlForm() {
    val hostnameProperty = SimpleStringProperty()
    var hostname = hostnameProperty

    val portProperty = SimpleStringProperty()
    var port = portProperty

    val usernameProperty = SimpleStringProperty()
    var username = usernameProperty

    val passwordProperty = SimpleStringProperty()
    var password = passwordProperty

    private val secretKey = "Mgo7FL5mN3XM1Ve9McOlgQt9Z5371xk7"

    fun toDto() = MainFormDto(
        hostname = hostname.value,
        port = port.value,
        username = username.value,
        password = password.value?.let { Encryptor.aesEncrypt(password.value, secretKey) }
    )

    fun fromDTO(dto: MainFormDto) {
        hostname.value = dto.hostname
        port.value = dto.port
        username.value = dto.username
        password.value = dto.password?.let { Encryptor.aesDecrypt(dto.password, secretKey) }
    }
}

@Serializable
data class MainFormDto(
    val hostname: String?,
    val port: String?,
    val username: String?,
    val password: String?
)