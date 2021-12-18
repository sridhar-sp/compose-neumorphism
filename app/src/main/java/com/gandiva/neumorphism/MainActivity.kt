package com.gandiva.neumorphism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*
import com.gandiva.neumorphism.ui.theme.AppColors
import com.gandiva.neumorphism.ui.theme.AppTextStyle
import com.gandiva.neumorphism.ui.theme.NeumorphismTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeumorphismTheme(darkTheme = false) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        InputBoxWithCardWrapper()
                        PlainInputBox()
                        CheckBoxAndRadioButtons()
                        PressedSlider()
                        FlatSlider()
                        PressedButton()
                        FlatButton()
                        CircleActionButton()
                    }
                }
            }
        }
    }
}

@Composable
fun DefaultSpacer() = Spacer(modifier = Modifier.size(8.dp))

val defaultWidgetPadding = 16.dp
val defaultElevation = 6.dp
val defaultCornerShape: CornerShape = RoundedCorner(12.dp)

@Preview
@Composable
fun InputBoxWithCardWrapper() {
    var searchText by remember {
        mutableStateOf("")
    }
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Pressed(defaultCornerShape)
            ),
    ) {
        TextField(
            value = searchText, onValueChange = { searchText = it },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
            ),
            textStyle = AppTextStyle.body1(),
            placeholder = { Text(text = "Search", style = AppTextStyle.body1Hint(), maxLines = 1) },
        )
    }
}


@Preview
@Composable
fun PlainInputBox() {
    var searchText by remember {
        mutableStateOf("")
    }
    TextField(
        value = searchText, onValueChange = { searchText = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Pressed(defaultCornerShape),
            ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
        ),
        textStyle = AppTextStyle.body1(),
        placeholder = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "Search")
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Search", style = AppTextStyle.body1Hint(), maxLines = 2)
            }
        },
    )
}

@Preview
@Composable
fun CheckBoxAndRadioButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
    ) {
        var pressedStyleCheckBoxState by remember {
            mutableStateOf(true)
        }
        Checkbox(
            modifier = Modifier
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(defaultCornerShape),
                ),
            checked = pressedStyleCheckBoxState,
            onCheckedChange = { pressedStyleCheckBoxState = it }
        )

        var flatStyleCheckBoxState by remember {
            mutableStateOf(false)
        }
        Card(
            modifier = Modifier
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(defaultCornerShape),
                )
        ) {
            Checkbox(
                checked = flatStyleCheckBoxState,
                onCheckedChange = { flatStyleCheckBoxState = it })
        }

        var pressedRadioButtonState by remember {
            mutableStateOf(true)
        }
        RadioButton(
            modifier = Modifier
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(defaultCornerShape),
                ),
            selected = pressedRadioButtonState,
            onClick = { pressedRadioButtonState = !pressedRadioButtonState })

        var flatRadioButtonState by remember {
            mutableStateOf(true)
        }

        Card(
            modifier = Modifier
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(defaultCornerShape),
                )
        ) {
            RadioButton(
                selected = flatRadioButtonState,
                onClick = { flatRadioButtonState = !flatRadioButtonState })
        }
    }
}

@Preview
@Composable
fun PressedSlider() {
    var sliderValue by remember {
        mutableStateOf(defaultElevation.value)
    }
    Slider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Pressed(defaultCornerShape),
            ),
        value = sliderValue, onValueChange = { sliderValue = it }, valueRange = 0f..12f
    )
}


@Preview
@Composable
fun FlatSlider() {
    var sliderValue by remember {
        mutableStateOf(defaultElevation.value)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(defaultCornerShape),
            )
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Slider(
                value = sliderValue, onValueChange = { sliderValue = it }, valueRange = 0f..12f
            )
        }
    }

}


@Preview
@Composable
fun PressedButton() {
    Button(
        onClick = { }, modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Pressed(defaultCornerShape),
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface,
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = null

    ) {
        Text(text = "Button", style = AppTextStyle.button())
    }
}

@Preview
@Composable
fun FlatButton() {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .defaultMinSize(minHeight = 80.dp)
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(defaultCornerShape),
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface
        )
    ) {
        Text(
            text = "Button", style = AppTextStyle.button()
        )
    }
}

@Preview
@Composable
fun CircleActionButton() {
    val imageSize = 48.dp
    Row(

        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
    ) {
        Image(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(Oval),
                ),
            painter = painterResource(id = R.drawable.ic_baseline_emoji_events_24),
            contentDescription = "Pressed image 1",
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        DefaultSpacer()
        Image(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(Oval),
                ),
            painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
            contentDescription = "Pressed image 2",
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )

        DefaultSpacer()

        Card(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(Oval),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
                contentDescription = "Flat image 1",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
        }
        DefaultSpacer()
        Card(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(Oval),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_anchor_24),
                contentDescription = "Flat image 2",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
        }
    }
}

@Preview
@Composable
fun Dropdown() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultWidgetPadding)

    ) {
        Button(
            onClick = { expanded = true }, modifier = Modifier
                .fillMaxWidth()
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(defaultCornerShape),
                ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.surface,
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = null

        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_android_24),
                    contentDescription = "Android OS dropdown"
                )
                Spacer(modifier = Modifier.size(defaultWidgetPadding))
                Text(
                    modifier = Modifier.weight(1f),
                    text = items[selectedIndex], style = AppTextStyle.button()
                )
                DefaultSpacer()
                Image(
                    painter = painterResource(
                        id = if (expanded) R.drawable.ic_baseline_keyboard_arrow_up_24
                        else R.drawable.ic_baseline_keyboard_arrow_down_24
                    ),
                    contentDescription = "Android OS dropdown"
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            items.forEachIndexed { index, value ->
                DropdownMenuItem(
                    onClick = {
                        selectedIndex = index
                        expanded = false
                    }) {

                    Text(text = value)
                }
            }
        }

    }
}
