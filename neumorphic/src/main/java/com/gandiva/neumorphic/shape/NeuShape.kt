package com.gandiva.neumorphic.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import com.gandiva.neumorphic.NeuStyle

abstract class NeuShape(open val cornerShape: CornerShape) {
    abstract fun draw(drawScope: ContentDrawScope, style: NeuStyle)
}