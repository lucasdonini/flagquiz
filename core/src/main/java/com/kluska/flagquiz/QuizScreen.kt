package com.kluska.flagquiz

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ScreenViewport

class QuizScreen(private val game: FlagQuizGame) : Screen {

    private lateinit var stage: Stage

    override fun show() {
        Logger.log("Activating QuizScreen...")
        stage = Stage(ScreenViewport())
        Gdx.input.inputProcessor = stage

        val flag = game.assets.get("flags/br.png", Texture::class.java)

        val root = Table().apply {
            setFillParent(true)
            center()

            val labelStyle = Label.LabelStyle(game.fonts.body, Color.WHITE)
            add(Label("Que país é esse?", labelStyle))
            row()

            add(Image(flag).apply { setScaling(Scaling.fit) })
                .maxWidth(400f)
                .maxHeight(260f)
                .pad(24f)
            row()
        }

        stage.addActor(root)
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.NAVY)

        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {
        stage.dispose()
    }

}
