package com.kluska.flagquiz.infra

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.kluska.flagquiz.repository.Logger

const val APP_TAG = "FlagQuiz"

class LoggerImpl : Logger {
    private var _debugEnabled = false

    override fun info(msg: String) = Gdx.app.log(APP_TAG, msg)

    override fun debug(msg: String) {
        if (!_debugEnabled) {
            Gdx.app.logLevel = Application.LOG_DEBUG
            _debugEnabled = true
        }
        Gdx.app.debug(APP_TAG, msg)
    }

    override fun error(msg: String) = Gdx.app.error(APP_TAG, msg)

    override fun exception(msg: String, exc: Exception) = Gdx.app.error(APP_TAG, msg, exc)
}
