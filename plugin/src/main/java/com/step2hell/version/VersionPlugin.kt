package com.step2hell.version

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("===========================> beginning of plugin 'VersionPlugin'")
    }

    companion object {}
}
