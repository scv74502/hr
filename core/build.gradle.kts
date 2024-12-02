import org.springframework.boot.gradle.tasks.bundling.BootJar

// jar 파일 생성에 사용, 라이브러리나 애플리케이션으로 배포하기 위해 필요함
val jar : Jar by tasks
// 공통 라이브러리는 스프링 부트 사용하지 않으므로 설정 필요하지 않음, 비활성화
val bootJar : BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies{
    //로그 의존성
    // https://mvnrepository.com/artifact/io.github.microutils/kotlin-logging-jvm
    api("io.github.microutils:kotlin-logging-jvm:3.0.5")
}