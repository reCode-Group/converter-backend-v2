package com.recode.plugins.core

import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class BaseTask : DefaultTask() {
    @TaskAction
    fun execute() = runBlocking {
        onPrepare()
        onAction()
        onRelax()
    }

    protected fun onPrepare() = Unit

    protected fun onRelax() = Unit

    protected abstract suspend fun onAction()
}