import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = true

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":external-api"))
    implementation(project(":external-api:public-client"))
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-hibernate5-jakarta
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-hibernate5-jakarta:2.18.2")
    // https://mvnrepository.com/artifact/io.mockk/mockk
    testImplementation("io.mockk:mockk:1.13.13")
    testImplementation(kotlin("test"))
}