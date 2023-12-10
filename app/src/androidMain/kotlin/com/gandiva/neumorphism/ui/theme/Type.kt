package com.gandiva.neumorphism.ui.theme

import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gandiva.neumorphism.R

private val fontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.poppins_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.poppins_regular_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.poppins_regular_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.poppins_medium,
            weight = FontWeight.W500,
            style = FontStyle.Normal
        )
    )
)

fun getTypography(isDarkTheme: Boolean): Typography {
    val textColor = if (isDarkTheme) AppColors.Dark.TextColor else AppColors.Light.TextColor
    return Typography(
        body1 = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = textColor
        ),
        body2 = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = textColor
        ),
        button = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            color = textColor
        ),
        caption = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = textColor
        )
    )

}

object AppTextStyle {

    @Composable
    fun body1() = MaterialTheme.typography.body1

    @Composable
    fun body1Hint() = body1().also {
        return it.copy(color = it.color.copy(alpha = ContentAlpha.medium))
    }

    @Composable
    fun subtitle1() = MaterialTheme.typography.subtitle1;

    @Composable
    fun subtitle2() = MaterialTheme.typography.subtitle2;

    @Composable
    fun button() = MaterialTheme.typography.button;

}