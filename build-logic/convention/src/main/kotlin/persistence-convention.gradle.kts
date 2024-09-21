import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("base-convention")
}

val libs = the<LibrariesForLibs>()

dependencies {
    // Spring JPA
    implementation(libs.spring.boot.starter.jpa)

    // H2 DB connector
    runtimeOnly(libs.database.engine.h2)
}