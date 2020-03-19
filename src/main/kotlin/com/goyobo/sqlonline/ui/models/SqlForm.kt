package com.goyobo.sqlonline.ui.models

import com.goyobo.sqlonline.utils.Encryptor
import javafx.beans.property.SimpleStringProperty
import kotlinx.serialization.Serializable

class SqlForm private constructor() {
    val hostname = SimpleStringProperty()
    val port = SimpleStringProperty()
    val schema = SimpleStringProperty()
    val username = SimpleStringProperty()
    val password = SimpleStringProperty()

    private val secretKey = "Mgo7FL5mN3XM1Ve9McOlgQt9Z5371xk7"

    private object HOLDER {
        val INSTANCE = SqlForm()
    }

    companion object {
        val instance: SqlForm by lazy { HOLDER.INSTANCE }
    }

    fun toDto() = MainFormDto(
        hostname = hostname.value,
        port = port.value,
        schema = schema.value,
        username = username.value,
        password = password.value?.let { Encryptor.aesEncrypt(password.value, secretKey) }
    )

    fun fromDTO(dto: MainFormDto) {
        hostname.value = dto.hostname
        port.value = dto.port
        schema.value = dto.schema
        username.value = dto.username
        password.value = dto.password?.let { Encryptor.aesDecrypt(dto.password, secretKey) }
    }
}

@Serializable
data class MainFormDto(
    val hostname: String? = "",
    val port: String? = "",
    val schema: String? = "",
    val username: String? = "",
    val password: String? = ""
)