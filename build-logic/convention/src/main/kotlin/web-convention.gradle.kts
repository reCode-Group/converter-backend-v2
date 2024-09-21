import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("base-convention")
}

val libs = the<LibrariesForLibs>()

dependencies {
    // Spring Web
    implementation(libs.spring.boot.starter.web)
    implementation(libs.jackson)

    // Spring service actuator
    implementation(libs.spring.boot.starter.actuator)
}