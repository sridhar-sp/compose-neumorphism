package com.gandiva.neumorphism

import App
import CheckBoxAndRadioButtons
import CircleActionButton
import FlatButton
import FlatSlider
import InputBoxWithCardWrapper
import PlainInputBox
import PressedButton
import PressedSlider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}


@Preview
@Composable
fun InputBoxWithCardWrapperPreview() {
    InputBoxWithCardWrapper()
}


@Preview
@Composable
fun PlainInputBoxPreview() {
    PlainInputBox()
}


@Preview
@Composable
fun CheckBoxAndRadioButtonsPreview() {
    CheckBoxAndRadioButtons()
}


@Preview
@Composable
fun PressedSliderPreview() {
    PressedSlider()
}


@Preview
@Composable
fun FlatSliderPreview() {
    FlatSlider()
}


@Preview
@Composable
fun PressedButtonPreview() {
    PressedButton()
}


@Preview
@Composable
fun FlatButtonPreview() {
    FlatButton()
}


@Preview
@Composable
fun CircleActionButtonPreview() {
    CircleActionButton()
}
