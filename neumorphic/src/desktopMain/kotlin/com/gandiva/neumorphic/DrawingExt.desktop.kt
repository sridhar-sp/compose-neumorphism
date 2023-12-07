package com.gandiva.neumorphic

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.NativePaint
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter


internal actual fun Any.makeNormalBlur(
    blurRadius: Float,
    @ColorInt color: Int,
    strokeWidth: Float?
) {
    this as NativePaint
    if (strokeWidth != null) {
        this.strokeWidth = strokeWidth
        this.setStroke(true)
    }
    this.maskFilter = MaskFilter.makeBlur(FilterBlurMode.NORMAL, blurRadius)
}
