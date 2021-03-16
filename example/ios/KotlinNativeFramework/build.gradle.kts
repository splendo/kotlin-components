buildscript {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

plugins {
    kotlin("multiplatform")
    kotlin("xcode-compat") version "0.2.5"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven(url="https://kotlin.bintray.com/kotlinx")
}

task("cleanKotlinNativeFrameworkTest")

kotlin {

    xcode {
        setupFramework("KotlinNativeFramework") {

            export(project(":shared"))

            transitiveExport = true
        }
    }

    sourceSets {
        getByName("KotlinNativeFrameworkMain") {

            val ext = (gradle as ExtensionAware).extra
            val primaryIosArch = ext["ios_primary_arch"]

            dependencies {
                api(project(":shared", "${primaryIosArch}Default"))
            }
        }
    }
}
