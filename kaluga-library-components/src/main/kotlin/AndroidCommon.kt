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

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies

fun org.gradle.api.Project.commonAndroidComponent(type: ComponentType = ComponentType.Default()) {
    android {
        androidCommon(this@commonAndroidComponent, type)
    }

    dependencies {
        implementationDependency(Dependencies.KotlinX.Coroutines.Android)
        implementationDependency(Dependencies.AndroidX.AppCompat)

        testImplementationDependency(Dependencies.JUnit)
        testImplementationDependency(Dependencies.Mockito.Core)
        testImplementationDependency(Dependencies.Kotlin.Test)
        testImplementationDependency(Dependencies.Kotlin.JUnit)

        androidTestImplementationDependency(Dependencies.Mockito.Android)
        androidTestImplementationDependency(Dependencies.ByteBuddy.Android)
        androidTestImplementationDependency(Dependencies.ByteBuddy.Agent)

        androidTestImplementationDependency(Dependencies.AndroidX.Test.Core)
        androidTestImplementationDependency(Dependencies.AndroidX.Test.CoreKtx)
        androidTestImplementationDependency(Dependencies.AndroidX.Test.UIAutomator)
        androidTestImplementationDependency(Dependencies.AndroidX.Test.Rules)
        androidTestImplementationDependency(Dependencies.AndroidX.Test.JUnit)
        androidTestImplementationDependency(Dependencies.AndroidX.Test.Runner)
        androidTestImplementationDependency(Dependencies.AndroidX.Test.Espresso)
        androidTestImplementationDependency(Dependencies.Kotlin.Test)
        androidTestImplementationDependency(Dependencies.Kotlin.JUnit)
    }
}

fun LibraryExtension.androidCommon(project: org.gradle.api.Project, componentType: ComponentType = ComponentType.Default()) {
    compileSdk = Library.Android.compileSdk
    buildToolsVersion = Library.Android.buildTools

    defaultConfig {
        minSdk = Library.Android.minSdk
        targetSdk = Library.Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    if (componentType.isApp) {
        project.logger.lifecycle("Android sourcesets for this project module are configured using defaults (for an app)")
    } else {
        project.logger.lifecycle("Android sourcesets for this project module are configured as a library")
        sourceSets {
            getByName("main") {
                manifest.srcFile("src/androidLibMain/AndroidManifest.xml")
                res.srcDir("src/androidLibMain/res")
                if (componentType is ComponentType.Compose) {
                    java.srcDir("src/androidLibMain/kotlin")
                }
            }
            getByName("androidTest") {
                manifest.srcFile("src/androidLibAndroidTest/AndroidManifest.xml")
                java.srcDir("src/androidLibAndroidTest/kotlin")
                res.srcDir("src/androidLibAndroidTest/res")
            }

            getByName("test") {
                java.srcDir("src/androidLibUnitTest/kotlin")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf("-XXLanguage:+InlineClasses", "-Xjvm-default=all")
    }

    when (componentType) {
        is ComponentType.Compose -> {
            project.logger.lifecycle("This project module is a Compose only module")
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Library.Android.composeCompiler
            }
        }
        is ComponentType.Default-> {}
    }
}
