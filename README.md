# Neumorphism using Jetpack Compose

Neumorphism design implementation in jetpack compose


## Sample app preview

Dark                       |            Light
:-------------------------:|:-------------------------:
![screen-dark]   |  ![screen-light]


## Features
* Draw shadows on widget to bring out the neumorphic design, following neumorphic components are supported.
  * Elevated view
  * Pit View
* All the above neumorphic component support two corner shape
  * RoundedCorner
  * Oval
* Simply add a single `neu` modifier on any `compose` component to create a *neumorphic* design

## Usage
Refer the [sample][sample-app-code-link] app provided for more information.

### Elevated design

#### Elevated button

Dark                       |            Light
:-------------------------:|:-------------------------:
![elevated-button-dark]   |  ![elevated-button-light]

```
    Button(
        modifier = Modifier
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
```


#### Elevated card view with rounded rectangle shape
Dark                       |            Light
:-------------------------:|:-------------------------:
![elevated-card-dark]   |  ![elevated-card-light]
```
    Card(
        modifier = Modifier
            .size(128.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(RoundedCorner(24.dp)),
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ){
    	// Add child components here.
    }
    
```

### Pit design

#### Pressed button

Dark                       |            Light
:-------------------------:|:-------------------------:
![pressed-button-dark]   |  ![pressed-button-light]

```
    Button(
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
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface,
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = null

    ) {
        Text(text = "Button", style = AppTextStyle.button())
    }
```

#### Pressed card view with rounded rectangle shape
Dark                       |            Light
:-------------------------:|:-------------------------:
![pressed-card-dark]   |  ![pressed-card-light]
```
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
    ){
    	// Add child components here.
    }
```

### Light source

LEFT_TOP | RIGHT_TOP | LEFT_BOTTOM | RIGHT_BOTTOM
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
![elevated_card_left_top_dark]| ![elevated_card_right_top_dark] | ![elevated_card_left_bottom_dark] |  ![elevated_card_right_bottom_dark]
![elevated_card_left_top_light]| ![elevated_card_right_top_light] | ![elevated_card_left_bottom_light] |  ![elevated_card_right_bottom_light]

### Shapes

Pressed                       |            Elevated
:-------------------------:|:-------------------------:
![shape_pressed_card_dark]   |  ![shape_elevated_card_dark]
![shape_pressed_card_light]  |  ![shape_elevated_card_light]


## Reference
* https://github.com/fornewid/neumorphism
* https://github.com/CRED-CLUB/synth-android

[sample-app-code-link]: app/src/main/java/com/gandiva/neumorphism/MainActivity.kt
[screen-dark]: docs/screens/neu_dark.png
[screen-light]: docs/screens/neu_light.png

[elevated-button-dark]: docs/clips/elevated_button_dark.png
[elevated-button-light]: docs/clips/elevated_button_light.png

[elevated-card-dark]: docs/clips/elevated_card_dark.png
[elevated-card-light]: docs/clips/elevated_card_light.png


[pressed-button-dark]: docs/clips/pressed_button_dark.png
[pressed-button-light]: docs/clips/pressed_button_light.png

[pressed-card-dark]: docs/clips/pressed_card_dark.png
[pressed-card-light]: docs/clips/pressed_card_light.png

[elevated_card_left_top_dark]: docs/clips/elevated_card_left_top_dark.png
[elevated_card_right_top_dark]: docs/clips/elevated_card_right_top_dark.png
[elevated_card_left_bottom_dark]: docs/clips/elevated_card_left_bottom_dark.png
[elevated_card_right_bottom_dark]: docs/clips/elevated_card_right_bottom_dark.png

[elevated_card_left_top_light]: docs/clips/elevated_card_left_top_light.png
[elevated_card_right_top_light]: docs/clips/elevated_card_right_top_light.png
[elevated_card_left_bottom_light]: docs/clips/elevated_card_left_bottom_light.png
[elevated_card_right_bottom_light]: docs/clips/elevated_card_right_bottom_light.png

[shape_elevated_card_dark]: docs/clips/shape_elevated_card_dark.png
[shape_elevated_card_light]: docs/clips/shape_elevated_card_light.png
[shape_pressed_card_dark]: docs/clips/shape_pressed_card_dark.png
[shape_pressed_card_light]: docs/clips/shape_pressed_card_light.png
