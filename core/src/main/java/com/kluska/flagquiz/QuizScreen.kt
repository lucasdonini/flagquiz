package com.kluska.flagquiz

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.ScreenUtils

class QuizScreen(private val game: FlagQuizGame) : Screen {

    private lateinit var flag: Texture

    override fun show() {
        Logger.log("QuizScreen activated")

        flag = game.assets.get("flags/br.png", Texture::class.java)
        Logger.log("br.png asset retrieved in QuizScreen")
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.NAVY)

        Logger.log("Rendering flag...")
        val x = (Gdx.graphics.width - flag.width) / 2f
        val y = (Gdx.graphics.height - flag.height) / 2f
        game.batch.render { draw(flag, x, y) }
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {}

}
