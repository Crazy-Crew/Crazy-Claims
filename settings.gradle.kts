@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositories.gradlePluginPortal()
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

// Project Name!
rootProject.name = "Crazy-Claims"

include("api", "paper")

enableFeaturePreview("VERSION_CATALOGS")