package com.kluska.flagquiz

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class FlagQuizGame : Game() {

    val assets = AssetManager()
    lateinit var batch: SpriteBatch
    lateinit var fonts: FlagQuizFonts

    override fun create() {
        Logger.log("FlagQuizGame started")

        Logger.log("Loading assets...")
//        assets.load("flags/br.png", Texture::class.java) Loads a specific flag
        val flagFiles = Gdx.files.internal("flags").list() // Loads all flags from assets/flags
        flagFiles.forEach { assets.load(it.path(), Texture::class.java) }
        assets.finishLoading()
        Logger.log("Assets loaded")

        Logger.log("Creating SpriteBatch singleton...")
        batch = SpriteBatch()

        Logger.log("Creating BitmapFont singleton for Roboto...")
        fonts = FlagQuizFonts(
            body = createFont("fonts/roboto.ttf", 36),
            title = createFont("fonts/roboto.ttf", 64)
        )

        setScreen(MenuScreen(this))
    }

    override fun render() {
        super.render()
    }

    private fun createFont(path: String, size: Int): BitmapFont {
        val generator = FreeTypeFontGenerator(Gdx.files.internal(path))
        val params = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.size = size
            color = Color.WHITE
            borderWidth = 1f
            borderColor = Color.BLACK
        }

        val font = generator.generateFont(params)
        generator.dispose()
        return font
    }

    override fun dispose() {
        Logger.log("Disposing assets...")
        assets.dispose()

        Logger.log("Disposing batch...")
        batch.dispose()

        Logger.log("Disposing fonts...")
        fonts.dispose()

        Logger.log("Disposing screen...")
        screen?.dispose()
    }

}
