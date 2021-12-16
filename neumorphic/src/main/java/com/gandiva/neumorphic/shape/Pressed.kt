package com.gandiva.neumorphic.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import com.gandiva.neumorphic.*

class Pressed(override val cornerShape: CornerShape) : NeuShape(cornerShape) {
    override fun draw(drawScope: ContentDrawScope, style: NeuStyle) {
        drawScope.drawContent()
        drawScope.drawForegroundShadows(this, style)
    }
}