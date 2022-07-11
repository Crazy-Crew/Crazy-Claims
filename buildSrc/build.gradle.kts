plugins {
    `kotlin-dsl`

    `java-library`
}

repositories {
    gradlePluginPortal()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation("io.papermc.paperweight.userdev:io.papermc.paperweight.userdev.gradle.plugin:1.3.7")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).apply {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}