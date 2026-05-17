package com.kluska.flagquiz

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.NinePatch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable
import com.kluska.flagquiz.di.appModule
import com.kluska.flagquiz.repository.Logger
import com.kluska.flagquiz.ui.fonts.FlagQuizFonts
import com.kluska.flagquiz.ui.screens.MenuScreen
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class FlagQuizGame : Game(), KoinComponent {

    private val logger: Logger by lazy { get() }

    val assets = AssetManager()
    lateinit var batch: SpriteBatch
    lateinit var fonts: FlagQuizFonts
    lateinit var skin: Skin

    override fun create() {
        setupKoin()

        logger.info("Starting FlagQuizGame...")
        loadAssets()
        createBatch()
        loadFonts()
        loadSkins()
        logger.info("FlagQuizGame setup complete")

        setScreen(MenuScreen(this))
    }

    private fun loadAssets() {
        logger.info("Loading assets...")
//        assets.load("flags/br.png", Texture::class.java) Loads a specific flag
        val flagFiles = Gdx.files.internal("flags").list() // Loads all flags from assets/flags
        flagFiles.forEach { assets.load(it.path(), Texture::class.java) }
        assets.finishLoading()
        logger.info("Assets loaded")
    }

    private fun createBatch() {
        logger.info("Creating SpriteBatch singleton...")
        batch = SpriteBatch()
    }

    private fun loadFonts() {
        logger.info("Creating BitmapFont singleton for Roboto...")
        fonts = FlagQuizFonts(
            body = createFont("fonts/roboto.ttf", 36),
            title = createFont("fonts/roboto.ttf", 64)
        )
    }

    private fun loadSkins() {
        logger.info("Creating default skin...")
        skin = createSkin()
    }

    private fun setupKoin() = startKoin { modules(appModule) }

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

    private fun createSkin(): Skin {
        val skin = Skin()

        // Textura branca 1x1 — base para todos os drawables
        val pixmap = Pixmap(1, 1, Pixmap.Format.RGBA8888).apply {
            setColor(Color.WHITE)
            fill()
        }
        val white = Texture(pixmap)
        pixmap.dispose()
        skin.add("white", white)

        val patch = NinePatchDrawable(NinePatch(white, 0, 0, 0, 0))

        // Label
        skin.add("default", Label.LabelStyle(fonts.body, Color.WHITE))

        // TextField
        skin.add("default", TextField.TextFieldStyle().apply {
            this.font = this@FlagQuizGame.fonts.body
            fontColor = Color.WHITE
            background = patch
            cursor = patch
            selection = patch
        })

        // TextButton
        skin.add("default", TextButton.TextButtonStyle().apply {
            this.font = this@FlagQuizGame.fonts.body
            fontColor = Color.WHITE
            up = patch
            down = patch
        })

        return skin
    }

    override fun render() = super.render()

    override fun dispose() {
        logger.info("Disposing assets...")
        assets.dispose()

        logger.info("Disposing batch...")
        batch.dispose()

        logger.info("Disposing fonts...")
        fonts.dispose()

        logger.info("Disposing screen...")
        screen?.dispose()
    }

}
