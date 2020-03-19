package com.goyobo.sqlonline.db

import com.vladsch.kotlin.jdbc.HikariCP
import com.vladsch.kotlin.jdbc.SessionImpl
import com.vladsch.kotlin.jdbc.sqlQuery
import com.vladsch.kotlin.jdbc.usingDefault

// TODO pre-check users schema privileges if possible
// TODO allow disconnect and reconnect to different databases
object Database {

    fun connect(hostname: String, port: String, username: String, password: String) {
        if (!connected()) {
            HikariCP.default("jdbc:mysql://$hostname:$port/sql_online", username, password)
            SessionImpl.defaultDataSource = { HikariCP.dataSource() }
        }
    }

    private fun connected(): Boolean {
        return SessionImpl.defaultDataSource != null
    }

    fun test() {
        usingDefault { session ->
            val test = sqlQuery("select * from numbers")
            session.list(test) { row ->
                println(row.int("id"))
            }
        }
    }
}
