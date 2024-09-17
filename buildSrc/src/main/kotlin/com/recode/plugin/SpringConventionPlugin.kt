package com.recode.plugin

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.plugin.use.PluginDependency

class SpringConventionPlugin : BaseConventionPlugin() {
    override fun configure(project: Project) {
        println("Configuring Spring Convention plugin")
    }

    override fun plugins(versionCatalog: VersionCatalog): List<PluginDependency> = listOf(

    )

    override fun libraries(versionCatalog: VersionCatalog): List<LibraryDependency> = listOf(

    )
}