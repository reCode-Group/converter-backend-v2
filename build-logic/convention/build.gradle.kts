plugins {
    `kotlin-dsl`
}

fun Provider<PluginDependency>.asLibrary(): String = with(this.get()) {
    when (pluginId) {
        "org.jetbrains.kotlin.jvm" -> "org.jetbrains.kotlin:kotlin-gradle-plugin"
        "org.jetbrains.kotlin.plugin.spring" -> "org.jetbrains.kotlin:kotlin-allopen"
        "org.jetbrains.kotlin.plugin.jpa" -> "org.jetbrains.kotlin:kotlin-noarg"
        "org.springframework.boot" -> "org.springframework.boot:spring-boot-gradle-plugin"
        "io.spring.dependency-management" -> "io.spring.gradle:dependency-management-plugin"
        "io.gitlab.arturbosch.detekt" -> "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
        else -> throw IllegalArgumentException("No matching plugin id: $pluginId")
    }.let { "$it:$version" }
}

dependencies {
    // Workaround: https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugins.kotlin.jvm.asLibrary())
    implementation(libs.plugins.kotlin.spring.asLibrary())
    implementation(libs.plugins.kotlin.jpa.asLibrary())
    implementation(libs.plugins.spring.boot.asLibrary())
    implementation(libs.plugins.spring.di.asLibrary())
    implementation(libs.plugins.detekt.asLibrary())
    implementation(projects.core)
}