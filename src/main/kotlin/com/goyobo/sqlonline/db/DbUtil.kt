package com.goyobo.sqlonline.db

import com.vladsch.kotlin.jdbc.HikariCP
import com.vladsch.kotlin.jdbc.SessionImpl
import com.vladsch.kotlin.jdbc.sqlQuery
import com.vladsch.kotlin.jdbc.usingDefault

class DbUtil private constructor() {

    private object HOLDER {
        val INSTANCE = DbUtil()
    }

    init {
        HikariCP.default("jdbc:mysql://localhost:3306/sql_online", "user", "root")
        SessionImpl.defaultDataSource = { HikariCP.dataSource() }
    }

    companion object {
        val instance: DbUtil by lazy { HOLDER.INSTANCE }
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