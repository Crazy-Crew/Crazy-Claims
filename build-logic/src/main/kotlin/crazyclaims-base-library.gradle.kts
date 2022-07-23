plugins {
    id("crazyclaims-kotlin-library")
    id("crazyclaims-java-library")
}

group = "com.badbones69.crazyclaims"
version = "1.0.0-${System.getenv("BUILD_NUMBER") ?: "SNAPSHOT"}"
description = "A working claims plugin?"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.bstats:bstats-bukkit:3.0.0")
}