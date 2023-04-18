/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

import java.nio.file.Files
import java.util.Calendar

abstract class NewModule : DefaultTask() {

    private companion object {
        const val VALID_MODULE_NAME_REGEX = "^[^\\dA-Z-][a-z]+[a-z-]*\\Z"
        const val VALID_PACKAGE_NAME_REGEX = "^[a-z]+(\\.[a-z]+)*\\Z"
        const val TEMPLATE_PATH = "adding-a-new-module/template"
        const val BUILD_GRADLE_KTS = "build.gradle.kts"
    }

    sealed class Templates {
        abstract val subpath: String
        abstract val createDirs: Map<String, List<String>>
        abstract val isAndroidModule: Boolean

        object Common : Templates() {
            override val subpath: String = "common"
            override val createDirs = mapOf(
                "androidLibInstrumentedTest" to listOf("kotlin/TestActivity.kt", "AndroidManifest.xml"),
                "androidLibMain" to emptyList(),
                "androidLibUnitTest" to emptyList(),
                "commonMain" to emptyList(),
                "commonTest" to emptyList(),
                "iosMain" to emptyList(),
                "iosTest" to emptyList(),
                "jsMain" to emptyList(),
                "jvmMain" to emptyList()
            )
            override val isAndroidModule: Boolean = false
        }

        object Test : Templates() {
            override val subpath: String = "test"
            override val createDirs = mapOf<String, List<String>>(
                "androidLibMain" to emptyList(),
                "commonMain" to emptyList(),
                "iosMain" to emptyList(),
                "jsMain" to emptyList(),
                "jvmMain" to emptyList()
            )
            override val isAndroidModule: Boolean = false
        }

        object Compose : Templates() {
            override val subpath: String = "compose"
            override val createDirs = mapOf(
                "androidTest" to listOf("kotlin/TestActivity.kt", "AndroidManifest.xml"),
                "main" to emptyList(),
                "test" to emptyList()
            )
            override val isAndroidModule: Boolean = true
        }

        object Databinding : Templates() {
            override val subpath: String = "databinding"
            override val createDirs = mapOf(
                "androidTest" to listOf("kotlin/TestActivity.kt", "AndroidManifest.xml"),
                "main" to emptyList(),
                "test" to emptyList()
            )
            override val isAndroidModule: Boolean = true
        }
    }

    data class Configuration(val baseModuleName: String, val basePackageName: String, val template: Templates) {
        val moduleName: String get() = when (template) {
            is Templates.Common -> baseModuleName
            is Templates.Test -> "test-utils-$baseModuleName"
            is Templates.Compose -> "$baseModuleName-compose"
            is Templates.Databinding -> "$baseModuleName-databinding"
        }

        val packageName: String get() = when (template) {
            is Templates.Common -> basePackageName
            is Templates.Test -> "test.$basePackageName"
            is Templates.Compose -> "$basePackageName.compose"
            is Templates.Databinding -> "$basePackageName.databinding"
        }
    }

    @get:Internal
    abstract val rootDir: DirectoryProperty
    @get:Internal
    abstract val configurations: ListProperty<Configuration>

    @TaskAction
    fun create() {
        if (!configurations.isPresent || configurations.get().isEmpty()) {
            throw GradleException("No module name provided! Use -P module_name=my-awesome-module")
        }

        configurations.get().forEach { it.createModule() }
    }

    private fun Configuration.createModule() {
        val outputDir = rootDir.get().dir(moduleName)
        val file = outputDir.asFile
        val module = file.name
        if (file.exists()) {
            throw GradleException("Module `$module` already exists!")
        }

        when {
            !module.matches(Regex(VALID_MODULE_NAME_REGEX)) -> throw GradleException("`$module` is not valid module name!")
            !packageName.matches(Regex(VALID_PACKAGE_NAME_REGEX)) -> throw GradleException("`$packageName` is not a valid package name!")
            else -> {
                val basePath = "../$TEMPLATE_PATH/${template.subpath}"
                template.createDirs.entries.forEach { (path, files) ->
                    val dir = outputDir.dir("src/${path}")
                    val kotlinDir = dir.dir(if (template.isAndroidModule) "java" else "kotlin") // ktlint does not work for src/*/kotlin/ when creating an android module
                    Files.createDirectories(kotlinDir.asFile.toPath())
                    files.forEach {
                        val from = outputDir.file("$basePath/src/${path}/$it").asFile
                        val to = dir.file(it).asFile
                        from.copyRecursively(to)
                        replaceVariable(to, this)
                    }
                }
                val buildGradleFile = outputDir.file("$basePath/$BUILD_GRADLE_KTS").asFile
                val to = outputDir.file(BUILD_GRADLE_KTS).asFile
                buildGradleFile.copyTo(to)
                replaceVariable(to, this)
            }
        }
        logger.lifecycle("New module `$module` has been created:")
        outputDir.asFileTree.visit {
            logger.lifecycle(this.file.canonicalPath)
        }
    }

    private fun replaceVariable(template: File, configuration: Configuration) {
        val content = template
            .readText()
            .replace("%PACKAGE%", configuration.packageName)
            .replace("%BASEMODULE%", configuration.baseModuleName)
            .replace("%YEAR%", "${Calendar.getInstance().get(Calendar.YEAR)}")
        template.writeText(content)
    }
}

tasks.register<NewModule>("createNewModule") {
    group = "utils"
    if (project.hasProperty("module_name")) {
        rootDir.set(file("./"))
        val moduleName = project.property("module_name").toString()
        val packageName = project.property(if (project.hasProperty("package_name")) "package_name" else "module_name").toString()
        configurations.set(
            listOfNotNull(
                NewModule.Configuration(moduleName, packageName, NewModule.Templates.Common),
                if (project.hasProperty("create-test-utils")) {
                    NewModule.Configuration(moduleName, packageName, NewModule.Templates.Test)
                } else null,
                if (project.hasProperty("create-compose")) {
                    NewModule.Configuration(moduleName, packageName, NewModule.Templates.Compose)
                } else null,
                if (project.hasProperty("create-databinding")) {
                    NewModule.Configuration(moduleName, packageName, NewModule.Templates.Databinding)
                } else null
            )
        )
    }
}

tasks.register<NewModule>("createNewTestModule") {
    group = "utils"
    if (project.hasProperty("module_name")) {
        rootDir.set(file("./"))
        val moduleName = project.property("module_name").toString()
        val packageName = project.property(if (project.hasProperty("package_name")) "package_name" else "module_name").toString()
        configurations.set(
            listOf(NewModule.Configuration(moduleName, packageName, NewModule.Templates.Test))
        )
    }
}

tasks.register<NewModule>("createNewComposeModule") {
    group = "utils"
    if (project.hasProperty("module_name")) {
        rootDir.set(file("./"))
        val moduleName = project.property("module_name").toString()
        val packageName = project.property(if (project.hasProperty("package_name")) "package_name" else "module_name").toString()
        configurations.set(
            listOf(NewModule.Configuration(moduleName, packageName, NewModule.Templates.Compose))
        )
    }
}

tasks.register<NewModule>("createNewDataBindingModule") {
    group = "utils"
    if (project.hasProperty("module_name")) {
        rootDir.set(file("./"))
        val moduleName = project.property("module_name").toString()
        val packageName = project.property(if (project.hasProperty("package_name")) "package_name" else "module_name").toString()
        configurations.set(
            listOf(NewModule.Configuration(moduleName, packageName, NewModule.Templates.Databinding))
        )
    }
}
