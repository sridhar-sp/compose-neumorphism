package com.gandiva.neumorphic.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import com.gandiva.neumorphic.NeuStyle
import com.gandiva.neumorphic.drawBackgroundShadows

class Flat(override val cornerShape: CornerShape) : NeuShape(cornerShape) {
    override fun draw(drawScope: ContentDrawScope, style: NeuStyle) {
        drawScope.drawBackgroundShadows(this, style)
        drawScope.drawContent()
    }
}