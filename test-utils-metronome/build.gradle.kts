plugins {
    id("com.splendo.kaluga.plugin")
}

kaluga {
    moduleName = "test.metronome"

    dependencies {
        common {
            main {
                implementation(project(":metronome"))
            }
        }
    }
}
