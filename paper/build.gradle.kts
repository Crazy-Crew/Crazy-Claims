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
    implementation(project(":api"))

    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")

    paperDevBundle("1.19-R0.1-SNAPSHOT")

    compileOnly(kotlin("stdlib", "1.7.0"))
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-v${project.version}.jar")
    }

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