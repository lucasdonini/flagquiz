package com.kluska.flagquiz.ui.screens

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.ScreenUtils
import com.kluska.flagquiz.FlagQuizGame
import com.kluska.flagquiz.repository.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MenuScreen(private val game: FlagQuizGame) : Screen, KoinComponent {

    private val logger: Logger by inject()
    private var timer: Float = 0f

    override fun show() {
        logger.info("MenuScreen activated")
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
