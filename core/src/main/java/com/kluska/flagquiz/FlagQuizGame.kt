package com.kluska.flagquiz

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class FlagQuizGame : Game() {

    val assets = AssetManager()
    lateinit var batch: SpriteBatch

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

        setScreen(MenuScreen(this))
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {
        Logger.log("Disposing assets...")
        assets.dispose()

        Logger.log("Disposing batch...")
        batch.dispose()

        Logger.log("Disposing screen...")
        screen?.dispose()
    }
}
