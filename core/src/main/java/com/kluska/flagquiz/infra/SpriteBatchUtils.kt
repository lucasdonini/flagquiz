package com.kluska.flagquiz.infra

import com.badlogic.gdx.graphics.g2d.SpriteBatch

fun SpriteBatch.render(block: SpriteBatch.() -> Unit) {
    begin()
    block()
    end()
}
