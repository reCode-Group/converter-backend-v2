@file:Suppress("UnstableApiUsage")

import java.net.URI

rootProject.name = "converter"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = URI("https://jitpack.io") }
    }
}