import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.3.5" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
    // plugin settings
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "2.0.21" apply false
    kotlin("plugin.jpa") version "2.0.21" apply false
}

// 모든 프로젝트에 공통으로 적용될 설정
allprojects {
    group = "org.ecoAndRich.api"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile>{
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    tasks.withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JvmTarget.JVM_17
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")

    dependencies {
        //Spring Web 의존성
        implementation("org.springframework.boot:spring-boot-starter-web")

        //공통사용
        // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
        implementation("com.fasterxml.jackson.core:jackson-core:2.18.2")
        // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
        implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        annotationProcessor("org.projectlombok:lombok")
        compileOnly("org.projectlombok:lombok")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}



