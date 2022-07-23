import gradle.kotlin.dsl.accessors._657ac3b2e5072282e18494eb2b5fc9d6.compileJava
import gradle.kotlin.dsl.accessors._657ac3b2e5072282e18494eb2b5fc9d6.java
import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    `java-library`
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    compileJava {
        options.release.set(17)
    }
}

sourceSets {
    main {
        java {
            srcDirs("src/main/kotlin")
        }
    }
}