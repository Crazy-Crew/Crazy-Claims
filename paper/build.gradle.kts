plugins {
    id("crazyclaims.paper-build")
    id("crazyclaims.parent-build")

    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    // Paper API
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")

    compileOnly("com.google.inject:guice:5.1.0")

    paperDevBundle("1.19-R0.1-SNAPSHOT")
}

tasks {
    shadowJar {}

    reobfJar {}

    assemble {
        dependsOn(reobfJar)
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(
                "version" to project.version,
                "description" to project.description
            )
        }
    }
}