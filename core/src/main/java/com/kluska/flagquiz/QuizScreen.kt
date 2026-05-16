package com.kluska.flagquiz

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.ScreenUtils

class QuizScreen(private val game: FlagQuizGame) : Screen {

    override fun show() {
        Logger.log("QuizScreen activated")

        val flag = game.assets.get("flags/br.png", Texture::class.java)
        Logger.log("br.png asset retrieved in QuizScreen")
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.NAVY)
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {}

}
