package com.kluska.flagquiz

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.ScreenUtils

class MenuScreen(private val game: FlagQuizGame) : Screen {

    private var timer: Float = 0f

    override fun show() {
        Logger.info("MenuScreen activated")
    }

    override fun render(delta: Float) {
        timer += delta
        ScreenUtils.clear(Color.DARK_GRAY)

        if (timer >= 3f) game.screen = QuizScreen(game)
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {}

}
