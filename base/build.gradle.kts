plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("maven-publish")
    id("com.android.library")
}

val ext =  (gradle as ExtensionAware).extra

apply(from = "../gradle/publishable_component.gradle")

group = "com.splendo.kaluga"
version = ext["library_version"]!!

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                val ext = (gradle as ExtensionAware).extra
                api("co.touchlab:stately-common:${ext["stately_version"]}")
                api("co.touchlab:stately-concurrency:${ext["stately_version"]}")
                api(project(":logging", ""))
            }
        }
        getByName("commonTest") {
            dependencies {
                api(project(":test-utils", ""))
            }
        }
    }

}

val singleSet =ext["ios_one_sourceset"] as Boolean

kotlin {
    sourceSets {
        val ext =  (gradle as ExtensionAware).extra
        getByName("${ext["ios_primary_arch"]}Main") {
            dependencies {
                api("co.touchlab:stately-common:${ext["stately_version"]}")
                api("co.touchlab:stately-concurrency:${ext["stately_version"]}")
                api(project(":logging", "${ext["ios_primary_arch"]}Default"))
            }
        }
    }
}

if (!singleSet)  {

    kotlin {

        sourceSets {
            val ext =  (gradle as ExtensionAware).extra
            getByName("${ext["ios_secondary_arch"]}Main") {
                dependencies {
                    api("co.touchlab:stately-common:${ext["stately_version"]}")
                    api("co.touchlab:stately-concurrency:${ext["stately_version"]}")
                    api(project(":logging", "${ext["ios_secondary_arch"]}Default"))
                }
            }
        }
        sourceSets {
            val ext =  (gradle as ExtensionAware).extra
            getByName("${ext["ios_secondary_arch"]}Main") {
                dependencies {
                    api("co.touchlab:stately-common:${ext["stately_version"]}")
                    api("co.touchlab:stately-concurrency:${ext["stately_version"]}")
                    api(project(":logging", "${ext["ios_secondary_arch"]}Default"))
                }
            }
        }
    }
}
