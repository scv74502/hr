import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = true

subprojects {
    val bootJar: BootJar by tasks
    dependencies {
        implementation(project(":core"))
        api("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.4")
    }
}
