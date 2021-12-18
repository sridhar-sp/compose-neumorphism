package com.gandiva.neumorphism.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = AppColors.Purple200,
    primaryVariant = AppColors.Purple700,
    secondary = AppColors.Teal200,

//    background = WidgetBackground,
//    surface = WidgetBackground,
////    onPrimary = Color.White,
////    onSecondary = Color.Black,
//    onBackground = Color.White,
//    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = AppColors.Purple200,
    onPrimary = Color.Black,

//    primaryVariant = AppColors.Purple700,
//    secondaryVariant = AppColors.WidgetBackground,
    secondary = AppColors.Purple500,
//    onSecondary = AppColors.WidgetBackground,


    background = AppColors.Gainsboro,
    onBackground = Color.Black,
    surface = AppColors.Gainsboro,
    onSurface = Color.Black,

//    error = Color(0xFFB00020),
//    onPrimary = Color.Black,
//    onError = Color.Black,

//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onBackground = Color.Black,
//    onSurface = Color.Black,
//    onError = Color.White
)

@Composable
fun NeumorphismTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}