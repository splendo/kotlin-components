plugins {
    kotlin("multiplatform")
    kotlin("xcode-compat") version "0.2.3"
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/pocketbyte/hydra/")
}

kotlin {
    xcode {
        setupFramework("KotlinNativeFramework")
    }

    sourceSets {
        getByName("KotlinNativeFrameworkMain") {


            val singleSet = (gradle as ExtensionAware).extra["ios_one_sourceset"] as Boolean
            var iosArch = (gradle as ExtensionAware).extra["ios_arch"]
            val orgArch = iosArch

            if (singleSet)
                iosArch = "ios"

            dependencies {

                implementation(project(":shared", "${iosArch}Default"))

                if (!((gradle as ExtensionAware).extra["exampleAsRoot"] as Boolean)) {
                    implementation(project(":Components", "${iosArch}Default"))
                } else {
                    implementation("com.splendo.mpp:Components-$orgArch:0.0.2")
                }

            }
        }
    }
}