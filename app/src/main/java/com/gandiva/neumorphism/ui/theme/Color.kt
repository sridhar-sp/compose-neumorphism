package com.gandiva.neumorphism.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object AppColors {
    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val Teal200 = Color(0xFF03DAC5)

    val Gainsboro = Color(0xFFDCDCDC)

    val LightShadow = Color(0xFFFFFFFF)
    val DarkShadow = Color(0xFFA8B5C7)


    @Composable
    fun lightShadow() = if (MaterialTheme.colors.isLight) Color.White else LightShadow

    @Composable
    fun darkShadow() = if (MaterialTheme.colors.isLight) DarkShadow else DarkShadow
}