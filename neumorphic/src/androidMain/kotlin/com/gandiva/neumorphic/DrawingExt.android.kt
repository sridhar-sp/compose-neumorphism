package com.gandiva.neumorphic

import androidx.annotation.ColorInt
import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.NativePaint


internal actual fun Any.makeNormalBlur(
    blurRadius: Float,
    @ColorInt color: Int,
    strokeWidth: Float?
) {
    this as NativePaint
    if (strokeWidth != null) {
        this.strokeWidth = strokeWidth
        this.style = android.graphics.Paint.Style.STROKE
    }
    this.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
}
