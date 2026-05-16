package com.kluska.flagquiz.infra

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx

object Logger {
    private var _debugEnabled = false
    const val APP_TAG = "FlagQuiz"
    fun info(msg: String) = Gdx.app.log(APP_TAG, msg)

    fun debug(msg: String) {
        if (!_debugEnabled) {
            Gdx.app.logLevel = Application.LOG_DEBUG
            _debugEnabled = true
        }
        Gdx.app.debug(APP_TAG, msg)
    }
}
