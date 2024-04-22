import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
}


val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

group = "com.porek"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation(project(":app:ports-output"))
    implementation(project(":app:commons"))

    implementation(group = "io.arrow-kt", name = "arrow-core", version = "1.2.1")
    implementation(group = "io.github.openfeign", name = "feign-core", version = "12.4")
    implementation(group = "io.github.openfeign", name = "feign-gson", version = "12.4")
    implementation(group = "io.github.openfeign", name = "feign-okhttp", version = "12.4")
    implementation(group = "io.github.openfeign", name = "feign-slf4j", version = "12.4")

    implementation(group = "com.fasterxml.jackson.core", name ="jackson-databind", version="2.16.0" )



    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
    archiveFileName.set("infrastructure.jar")
}