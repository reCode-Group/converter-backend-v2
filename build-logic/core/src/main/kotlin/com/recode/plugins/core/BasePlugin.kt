package com.recode.plugins.core

import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class BasePlugin : Plugin<Project> {
    final override fun apply(target: Project) = with(target) { execute() }

    protected abstract fun Project.execute()
}