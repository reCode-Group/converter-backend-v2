import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

val libs = the<LibrariesForLibs>()

dependencies {
    // For Spring DI
    implementation(libs.kotlin.reflect)

    // For Unit testing
    testImplementation(libs.kotlin.test)
    testImplementation(libs.spring.boot.starter.testing)
    testRuntimeOnly(libs.junit.launcher)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}