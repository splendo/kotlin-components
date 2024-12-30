plugins {
    id("com.splendo.kaluga.plugin")
}

kaluga {
    moduleName = "metronome"

    dependencies {
        common {
            main {
                implementation(project(":base"))
                implementation(project(":logging"))
            }
            test {
                implementation(project(":test-utils-base"))
            }
        }
    }
}
