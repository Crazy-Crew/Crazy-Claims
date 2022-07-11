plugins {
    // Paper-weight
    id("io.papermc.paperweight.userdev")
}

group = "com.badbones69.crazyclaims"
version = "1.0.0-${System.getenv("BUILD_NUMBER") ?: "SNAPSHOT"}"
description = "A paper impl of Crazy Claims."

repositories {
    mavenCentral()
}