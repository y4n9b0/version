package com.step2hell.version

import org.gradle.api.Plugin
import org.gradle.api.Project
import kotlin.reflect.full.memberProperties

class VersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("\n====> Print Versions:")
        for (prop in Versions::class.memberProperties) {
            println("${prop.name} = ${prop.get(Versions)}")
        }

        println("\n====> Print Dependencies:")
        for (prop in Dependencies::class.memberProperties) {
            println("${prop.name} = ${prop.get(Dependencies)}")
        }
    }

    companion object {}
}
