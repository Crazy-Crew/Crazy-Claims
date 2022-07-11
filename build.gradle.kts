plugins {
    // Run paper server for easy testing.
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

tasks {
    runServer {
        minecraftVersion("1.19")

        runDirectory(File("server"))
    }
}