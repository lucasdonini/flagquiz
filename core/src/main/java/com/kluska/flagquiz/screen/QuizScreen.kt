package com.kluska.flagquiz.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.kluska.flagquiz.FlagQuizGame
import com.kluska.flagquiz.infra.Logger

class QuizScreen(private val game: FlagQuizGame) : Screen {

    private lateinit var stage: Stage

    override fun show() {
        Logger.info("Creating QuizScreen...")
        stage = Stage(ScreenViewport())
        Gdx.input.inputProcessor = stage

        Logger.info("Loading flag...")
        val flag = game.assets.get("flags/br.png", Texture::class.java)

        Logger.info("Creating input text field...")
        val textField = TextField("", game.skin).apply {
            messageText = "Type the country's name..."
        }

        Logger.info("Creating confirm button...")
        val button = TextButton("Confirm", game.skin).apply {
            addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    val response = textField.text
                    Logger.info("Quiz answered")
                    Logger.debug("Response: $response")
                    // Verification logic coming in Module 3
                }
            })
        }

        Logger.info("Building screen...")
        val root = Table().apply {
            setFillParent(true)
            center()
            pad(24f)

            val labelStyle = Label.LabelStyle(game.fonts.body, Color.WHITE)
            add(Label("Que país é esse?", labelStyle)).row()

            val img = Image(flag).apply { setScaling(Scaling.fit) }
            add(img).maxWidth(400f).maxHeight(260f).pad(24f).row()

            add(textField).width(300f).row()
            add(button).width(300f).padTop(16f)
        }

        stage.addActor(root)
        stage.keyboardFocus = textField
        Gdx.input.setOnscreenKeyboardVisible(true)
        Logger.info("QuizScreen created successfully")
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
