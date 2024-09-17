plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    id("com.recode.plugin.convention.spring")
}

group = "com.recode"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.jpa)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.jackson)
    implementation(libs.kotlin.reflect)
    runtimeOnly(libs.database.engine.h2)
    testImplementation(libs.spring.boot.starter.testing)
    testImplementation(libs.kotlin.test)
    testRuntimeOnly(libs.junit.launcher)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
