package com.kluska.flagquiz.repository

interface Logger {
    fun info(msg: String)
    fun debug(msg: String)
    fun error(msg: String)
    fun exception(msg: String = "", exc: Exception)
}
