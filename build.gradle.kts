plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetpack.compose) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.nexus.publish) apply false
    alias(libs.plugins.dokka) apply false
}

val artifactGroupId by extra("io.github.sridhar-sp")
val artifactVersion by extra("0.0.6")

apply(from = "neumorphic/maven-central-publish-root.gradle")
