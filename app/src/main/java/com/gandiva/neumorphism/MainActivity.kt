package com.gandiva.neumorphism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Oval
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphism.ui.theme.DarkShadow
import com.gandiva.neumorphism.ui.theme.LightShadow
import com.gandiva.neumorphism.ui.theme.NeumorphismTheme
import com.gandiva.neumorphism.ui.theme.WidgetBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeumorphismTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = WidgetBackground, modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        FlatButton()
                        Main()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FlatButton() {
    val lightSource = LightSource.LEFT_TOP
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier.neu(
            lightShadowColor = LightShadow,
            darkShadowColor = DarkShadow,
            shadowElevation = 4.dp,
            lightSource = lightSource,
            shape = Pressed(Oval),
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = WidgetBackground,

        ),
        shape = RoundedCornerShape(0.dp),
        elevation = null

    ) {
        Text(text = "Button")
    }
}

@Preview(showBackground = true)
@Composable
fun Main() {
    var count by remember {
        mutableStateOf(0)
    }
    var elevation by remember {
        mutableStateOf(2f)
    }

    var lightSource by remember {
        mutableStateOf(LightSource.LEFT_TOP)
    }

    fun LightSource.next(): LightSource {
        return when (this) {
            LightSource.LEFT_TOP -> LightSource.RIGHT_TOP
            LightSource.RIGHT_TOP -> LightSource.RIGHT_BOTTOM
            LightSource.LEFT_BOTTOM -> LightSource.LEFT_TOP
            LightSource.RIGHT_BOTTOM -> LightSource.LEFT_BOTTOM
        }
    }

    Box {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Card(
                backgroundColor = WidgetBackground,
                shape = RoundedCornerShape(64.dp),
                elevation = 0.dp,
                modifier = Modifier
                    .size(128.dp)
//                    .width(384.dp)
//                    .height(128.dp)
                    .padding(0.dp)
                    .neu(
                        lightShadowColor = LightShadow,
                        darkShadowColor = DarkShadow,
                        shadowElevation = elevation.dp,
                        lightSource = lightSource,
                        shape = Pressed(Oval),
//                        shape = Pressed(Oval),
                    )
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        count++
                    }

            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(.7f),
                    )
                }
                Text(
                    text = "Elevation ${elevation.dp}",
                    modifier = Modifier.padding(24.dp)
                )
            }

            Slider(
                value = elevation,
                onValueChange = { elevation = it },
                valueRange = 0f..64f,
                modifier = Modifier.padding(32.dp),
                steps = 64
            )
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                Button(onClick = { lightSource = lightSource.next() }) {
                    Text(text = lightSource.toString())
                }
            }

        }
    }

}
