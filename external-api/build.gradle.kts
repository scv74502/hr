val jar: Jar by tasks
jar.enabled = true

subprojects {
    val jar: Jar by tasks
    jar.enabled = true

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation(project(":core"))
        api("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.4")
    }

    // BootJar 비활성화
    tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        enabled = false
    }
}

// BootJar 비활성화
tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    enabled = false
}
