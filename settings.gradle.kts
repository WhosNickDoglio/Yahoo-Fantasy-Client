import de.fayard.refreshVersions.bootstrapRefreshVersions

buildscript {
    repositories { gradlePluginPortal() }
    dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
}

plugins {
    id("com.gradle.enterprise").version("3.5")
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

bootstrapRefreshVersions()

rootProject.name = "Yahoo-Fantasy-Client-Kotlin"
include(
    "yahoo-fantasy-client",
    "resources",
    "network-resources",
    "resource-adapters",
    "network-resources-annotations",
    "core"
)
