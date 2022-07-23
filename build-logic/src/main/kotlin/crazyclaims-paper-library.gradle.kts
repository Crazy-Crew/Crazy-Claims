import org.gradle.kotlin.dsl.maven

plugins {
    id("crazyclaims-java-library")
    // Paper-weight
    //id("io.papermc.paperweight.userdev")
}

repositories {
    mavenCentral()

    // Paper API
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    //paperDevBundle("1.19-R0.1-SNAPSHOT")

    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}