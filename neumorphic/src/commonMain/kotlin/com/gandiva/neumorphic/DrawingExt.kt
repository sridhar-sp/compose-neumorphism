package com.gandiva.neumorphic

import android.graphics.BlurMaskFilter
import androidx.annotation.ColorInt
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import com.gandiva.neumorphic.shape.CornerShape
import com.gandiva.neumorphic.shape.NeuShape
import com.gandiva.neumorphic.shape.Oval
import com.gandiva.neumorphic.shape.RoundedCorner


internal fun ContentDrawScope.drawBackgroundShadows(
    neuShape: NeuShape, style: NeuStyle
) {
    val elevation = style.shadowElevation.toPx()

    drawBlurredBackground(style.lightSource, elevation, style.lightShadowColor.toArgb(), neuShape.cornerShape)
    drawBlurredBackground(style.lightSource.opposite(), elevation, style.darkShadowColor.toArgb(), neuShape.cornerShape)
}

private fun ContentDrawScope.drawBlurredBackground(
    lightSource: LightSource,
    elevation: Float,
    @ColorInt color: Int,
    cornerShape: CornerShape
) {
    drawIntoCanvas { canvas ->

        val blurRadius = elevation * .95f
        val displacement = elevation * .6f

        if (blurRadius <= 0)
            return@drawIntoCanvas

        val paint = Paint().also { p ->
            p.asFrameworkPaint().also { nativePaint ->
                nativePaint.isAntiAlias = true
                nativePaint.isDither = true
                nativePaint.color = color
                nativePaint.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
            }
        }

        val backgroundOffset = when (lightSource) {
            LightSource.LEFT_TOP -> Offset(-displacement, -displacement)
            LightSource.RIGHT_TOP -> Offset(displacement, -displacement)
            LightSource.LEFT_BOTTOM -> Offset(-displacement, displacement)
            LightSource.RIGHT_BOTTOM -> Offset(displacement, displacement)
        }

        canvas.save()
        canvas.translate(backgroundOffset.x, backgroundOffset.y)
        when (cornerShape) {
            is Oval -> canvas.drawOval(0f, 0f, this.size.width, this.size.height, paint)
            is RoundedCorner -> canvas.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                cornerShape.radius.toPx(),
                cornerShape.radius.toPx(),
                paint
            )
        }
        canvas.restore()
    }
}

internal fun ContentDrawScope.drawForegroundShadows(
    neuShape: NeuShape, style: NeuStyle
) {
    val elevation = style.shadowElevation.toPx()

    drawForeground(style.lightSource, elevation, style.darkShadowColor.toArgb(), neuShape.cornerShape)
    drawForeground(
        style.lightSource.opposite(),
        elevation,
        style.lightShadowColor.toArgb(),
        neuShape.cornerShape
    )
}

private fun ContentDrawScope.drawForeground(
    lightSource: LightSource,
    elevation: Float,
    @ColorInt color: Int,
    cornerShape: CornerShape
) {

    drawIntoCanvas { canvas ->
        if (elevation <= 0)
            return@drawIntoCanvas

        val blurRadius = elevation * 0.6f
        val strokeWidth = elevation * .95f

        val paint = Paint().also { p ->
            p.asFrameworkPaint().also { nativePaint ->
                nativePaint.isAntiAlias = true
                nativePaint.color = color
                nativePaint.strokeWidth = strokeWidth
                nativePaint.style = android.graphics.Paint.Style.STROKE
                nativePaint.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
            }
        }

        val backgroundOffset = when (lightSource) {
            LightSource.LEFT_TOP -> Offset(strokeWidth, strokeWidth)
            LightSource.RIGHT_TOP -> Offset(-strokeWidth, strokeWidth)
            LightSource.LEFT_BOTTOM -> Offset(strokeWidth, -strokeWidth)
            LightSource.RIGHT_BOTTOM -> Offset(-strokeWidth, -strokeWidth)
        }

        canvas.save()
        when (cornerShape) {
            is Oval -> {
                val visiblePath = Path().also { p ->
                    p.moveTo(0f, 0f)
                    p.addOval(Rect(0f, 0f, this.size.width, this.size.height))
                }
                canvas.clipPath(visiblePath)
                canvas.translate(backgroundOffset.x, backgroundOffset.y)
                canvas.drawOval(
                    -strokeWidth,
                    -strokeWidth,
                    this.size.width + strokeWidth,
                    this.size.height + strokeWidth,
                    paint
                )
            }
            is RoundedCorner -> {
                val cornerRadius = cornerShape.radius.toPx()
                val visiblePath = Path().also { p ->
                    p.moveTo(0f, 0f)
                    p.addRoundRect(RoundRect(0f, 0f, this.size.width, this.size.height, cornerRadius, cornerRadius))
                }

                canvas.clipPath(visiblePath)

                canvas.translate(backgroundOffset.x, backgroundOffset.y)
                canvas.drawRoundRect(
                    -strokeWidth,
                    -strokeWidth,
                    this.size.width + strokeWidth,
                    this.size.height + strokeWidth,
                    cornerRadius,
                    cornerRadius,
                    paint
                )
            }
        }
        canvas.restore()

    }
}
