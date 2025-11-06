plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.3"
}

group = "com.example.demo3"
version = "1.0.0"

repositories {
    mavenCentral()
}

intellij {
    version.set("PC-2024.2")
    type.set("PC")
    plugins.set(listOf())
}

tasks {
    patchPluginXml {
        sinceBuild.set("232")
        untilBuild.set("999.*")
    }

    buildSearchableOptions { enabled = false }

    test {
        useJUnitPlatform()
    }
}
