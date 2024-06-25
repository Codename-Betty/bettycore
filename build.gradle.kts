plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "2.2.2"
    id("io.papermc.paperweight.userdev") version "1.7.1"
}

group = "dev.cnbetty.core"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}


dependencies {
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    implementation("org.tomlj:tomlj:1.1.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    test {
        useJUnitPlatform()
    }
    runServer {
        downloadPlugins{
            url("https://cdn.modrinth.com/data/evkiwA7V/versions/2aIoW39P/AxiomPaper-1.5.11.jar")
            url("https://ci.lucko.me/job/spark/418/artifact/spark-bukkit/build/libs/spark-1.10.73-bukkit.jar")
        }
        minecraftVersion("1.20.6")
    }
    assemble {
        dependsOn(reobfJar)
    }
}

