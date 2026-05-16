package com.kluska.flagquiz

import com.badlogic.gdx.graphics.g2d.BitmapFont

class FlagQuizFonts(
    val title: BitmapFont,
    val body: BitmapFont
) {
    fun dispose() {
        title.dispose()
        body.dispose()
    }
}
