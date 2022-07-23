import gradle.kotlin.dsl.accessors._657ac3b2e5072282e18494eb2b5fc9d6.compileKotlin
import gradle.kotlin.dsl.accessors._657ac3b2e5072282e18494eb2b5fc9d6.compileOnly

plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).apply {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

dependencies {
    compileOnly(kotlin("stdlib", "1.7.10"))
    compileOnly(kotlin("reflect", "1.7.10"))
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}