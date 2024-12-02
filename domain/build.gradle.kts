import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks
jar.enabled = true
bootJar.enabled = true

plugins {
    kotlin("kapt")
    kotlin("plugin.jpa")
}

dependencies {
    api(project(":core"))
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java:8.0.33")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")
}