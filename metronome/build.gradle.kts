plugins {
    id("com.splendo.kaluga.plugin")
}

kaluga {
    moduleName = "metronome"

    dependencies {
        common {
            main {
                implementation(project(":base"))
                implementation(project(":media"))
                implementation(project(":scientific"))
                implementation(project(":logging"))
            }
            test {
                implementation(project(":test-utils-base"))
                implementation(project(":test-utils-metronome"))
            }
        }
    }
}
