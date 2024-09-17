plugins {
    `kotlin-dsl`
    kotlin("jvm") version embeddedKotlinVersion
}

dependencies {
    implementation(gradleApi())
}

gradlePlugin {
    plugins {
        create("convention.spring") {
            id = "com.recode.plugin.convention.spring"
            implementationClass = "com.recode.plugin.SpringConventionPlugin"
        }
    }
}