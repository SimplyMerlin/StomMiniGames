plugins {
    kotlin("jvm") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    application
}

tasks {
    jar {
        archiveFileName.set("blockparty.jar")
    }
}

group = "com.simplymerlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("com.github.Minestom:Minestom:eb06ba8664")
    implementation("com.github.Minikloon:FSMgasm:bd1b5057a3")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("com.simplymerlin.blockparty.MainKt")
}

tasks {
    build { dependsOn(shadowJar) }

    jar {
        manifest {
            attributes["Main-Class"] = application.mainClass
        }
    }
}