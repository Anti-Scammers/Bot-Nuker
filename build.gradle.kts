plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.trolman.nuke"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.15")

}


application {
    mainClass.set("MainKt")
}