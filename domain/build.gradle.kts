import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import org.springframework.boot.gradle.tasks.bundling.BootJar

val querydslVersion: String by System.getProperties()

//val jar: Jar by tasks
val bootJar: BootJar by tasks
//jar.enabled = true
bootJar.enabled = false

plugins {
    kotlin("kapt")
    kotlin("plugin.jpa")
}

dependencies {
    val kapt by configurations
    api(project(":core"))
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    // Spring boot 3.x이상에서 QueryDsl 패키지를 정의하는 방법
    api("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")  // querydsl kapt setting
    runtimeOnly("mysql:mysql-connector-java:8.0.33")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val querydslDir = "${layout.buildDirectory}/generated/querydsl"


