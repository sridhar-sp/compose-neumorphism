@file:OptIn(ExperimentalResourceApi::class)

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.AppColors
import ui.theme.AppTextStyle
import ui.theme.NeumorphismTheme


@Composable
fun App() {
    var isDarkTheme by remember {
        mutableStateOf(true)
    }
    NeumorphismTheme(isDarkTheme = isDarkTheme) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                TitleWithThemeToggle(
                    title = "Neumorphic UI",
                    isDarkTheme = isDarkTheme
                ) {
                    isDarkTheme = !isDarkTheme
                }
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


@Composable
fun TitleWithThemeToggle(title: String, isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = defaultWidgetPadding),
            text = title,
            style = AppTextStyle.body1(), maxLines = 1
        )
        ImageButton(
            modifier = Modifier.padding(defaultWidgetPadding),
            drawableResId = if (isDarkTheme) "ic_baseline_light_mode.xml"
            else "ic_baseline_dark_mode_24.xml",
            contentDescription = "Toggle theme",
            onClick = onThemeToggle
        )
    }
}

@Composable
fun DefaultSpacer() = Spacer(modifier = Modifier.size(8.dp))

val defaultWidgetPadding = 16.dp
val defaultElevation = 6.dp
val defaultCornerShape: CornerShape = RoundedCorner(12.dp)

@Composable
fun defaultPressedNetAttrs() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Pressed(defaultCornerShape),
)

@Composable
fun defaultFlatNeuAttrs() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Flat(defaultCornerShape)
)

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
            .neu(defaultPressedNetAttrs()),
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
            .neu(defaultPressedNetAttrs()),
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
                Icon(painter = painterResource("ic_baseline_search_24.xml"), contentDescription = "Search")
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Search", style = AppTextStyle.body1Hint())
            }
        },
    )
}

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
                .neu(defaultPressedNetAttrs()),
            checked = pressedStyleCheckBoxState,
            onCheckedChange = { pressedStyleCheckBoxState = it }
        )

        var flatStyleCheckBoxState by remember {
            mutableStateOf(false)
        }
        Card(
            modifier = Modifier
                .neu(defaultFlatNeuAttrs())
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
                .neu(defaultPressedNetAttrs()),
            selected = pressedRadioButtonState,
            onClick = { pressedRadioButtonState = !pressedRadioButtonState })

        var flatRadioButtonState by remember {
            mutableStateOf(false)
        }

        Card(
            modifier = Modifier
                .neu(defaultFlatNeuAttrs())
        ) {
            RadioButton(
                selected = flatRadioButtonState,
                onClick = { flatRadioButtonState = !flatRadioButtonState })
        }
    }
}

@Composable
fun PressedSlider() {
    var sliderValue by remember {
        mutableStateOf(defaultElevation.value)
    }
    Slider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(defaultPressedNetAttrs()),
        value = sliderValue, onValueChange = { sliderValue = it }, valueRange = 0f..12f
    )
}

@Composable
fun FlatSlider() {
    var sliderValue by remember {
        mutableStateOf(defaultElevation.value)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(defaultFlatNeuAttrs())
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Slider(
                value = sliderValue, onValueChange = { sliderValue = it }, valueRange = 0f..12f
            )
        }
    }
}

@Composable
fun PressedButton() {
    Button(
        onClick = { }, modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(defaultPressedNetAttrs()),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface,
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = null

    ) {
        Text(text = "Button", style = AppTextStyle.button())
    }
}

@Composable
fun FlatButton() {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .defaultMinSize(minHeight = 80.dp)
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
            .neu(defaultFlatNeuAttrs()),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface
        )
    ) {
        Text(
            text = "Button", style = AppTextStyle.button()
        )
    }
}

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
            painter = painterResource("ic_baseline_emoji_events_24.xml"),
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
            painter = painterResource("ic_baseline_thumb_up_24.xml"),
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
                painter = painterResource("ic_baseline_emoji_emotions_24.xml"),
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
                painter = painterResource("ic_baseline_anchor_24.xml"),
                contentDescription = "Flat image 2",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
        }
    }
}

@Composable
fun ImageButton(
    modifier: Modifier,
    drawableResId: String,
    contentDescription: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .size(48.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(Oval),
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {
        Image(
            modifier = Modifier.clickable(true, onClick = onClick),
            painter = painterResource(drawableResId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
    }
}

@Composable
fun PressedSwitch() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = isChecked, onCheckedChange = { isChecked = !isChecked },
        modifier = Modifier.neu(
            NeuAttrs(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Pressed(RoundedCorner(0.dp)),
            )
        )
    )
}

@Composable
fun PressedExample() {
    Card(
        modifier = Modifier
            .size(128.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Pressed(RoundedCorner(24.dp)),
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {}
}

@Composable
fun ElevatedExample(lightSource: LightSource, shape: NeuShape) {
    Card(
        modifier = Modifier
            .size(96.dp)
            .neu(
                NeuAttrs(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = lightSource,
                    shape = shape,
                )
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {}
}
