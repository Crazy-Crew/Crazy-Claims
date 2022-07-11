plugins {
    java
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()

    // Paper API
    maven("https://repo.papermc.io/repository/maven-public/")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
}