package com.gandiva.neumorphic

/**
 * Light source constants with some utils functions.
 */
enum class LightSource {
    LEFT_TOP,
    RIGHT_TOP,
    LEFT_BOTTOM,
    RIGHT_BOTTOM;

    fun opposite(): LightSource {
        return when (this) {
            LEFT_TOP -> RIGHT_BOTTOM
            RIGHT_TOP -> LEFT_BOTTOM
            LEFT_BOTTOM -> RIGHT_TOP
            RIGHT_BOTTOM -> LEFT_TOP
        }
    }
}
