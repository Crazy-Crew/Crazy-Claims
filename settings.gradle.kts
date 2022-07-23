dependencyResolutionManagement {
    includeBuild("build-logic")
}

// Project Name!
rootProject.name = "Crazy-Claims"

include("api", "paper")

enableFeaturePreview("VERSION_CATALOGS")