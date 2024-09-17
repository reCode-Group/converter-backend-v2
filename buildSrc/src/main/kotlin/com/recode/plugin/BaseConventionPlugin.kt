package com.recode.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependency

abstract class BaseConventionPlugin(
    private val versionCatalogName: String = "libs"
) : Plugin<Project> {
    protected abstract fun configure(project: Project)

    protected abstract fun plugins(versionCatalog: VersionCatalog): List<PluginDependency>
    protected abstract fun libraries(versionCatalog: VersionCatalog): List<LibraryDependency>

    final override fun apply(project: Project) {
        val versionCatalog: VersionCatalog = project.extensions
            .getByType(VersionCatalogsExtension::class.java)
            .named(versionCatalogName)
        configure(project)
    }

    protected data class LibraryDependency(
        val libraryId: String,
        val configurationName: String
    )

    protected companion object {
        const val api: String = "api"
        const val implementation: String = "implementation"
        const val compileOnly: String = "compileOnly"
        const val compileOnlyApi: String = "compileOnlyApi"
        const val runtimeOnly: String = "runtimeOnly"
        const val testImplementation: String = "testImplementation"
        const val testCompileOnly: String = "testCompileOnly"
        const val testRuntimeOnly: String = "testRuntimeOnly"
    }
}