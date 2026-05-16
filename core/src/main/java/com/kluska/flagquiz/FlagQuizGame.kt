package com.kluska.flagquiz

import com.badlogic.gdx.Game

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class FlagQuizGame : Game() {

    override fun create() {
        Logger.log("FlagQuizGame started")
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {}
}
