package com.hr.api

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EntityScan(basePackages = ["com.hr.domain"])
//@EnableJpaRepositories(basePackages = ["com.hr.domain"])
class ApiApplication(){

}

// Jackson Hibernate5JakartaModule 모듈을 위한 Bean 생성하기
@Bean
fun Hibernate5JakartaModule(): Hibernate5JakartaModule? {
    return Hibernate5JakartaModule()
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
