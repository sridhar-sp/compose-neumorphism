plugins {
    kotlin("android")
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetpack.compose)
}

android {
    namespace = "com.gandiva.neumorphism"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    libraryVariants.all {
        outputs.all {
            packageLibraryProvider {
                archiveFileName.set(getArtifactName())
            }
        }
    }
}

fun getArtifactName(): String {
    val versionName = project.rootProject.extra["artifactVersion"] as String
    return "neumorphic-$versionName.aar"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.compose.ui)
    api(compose.runtime)
    api(compose.foundation)
    api(compose.material)
    api(libs.compose.ui.tooling.preview)
}

apply(from = "./publish-android-library.gradle")
