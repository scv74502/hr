package com.hr.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["com.hr.domain"])
@EnableJpaRepositories(basePackages = ["com.hr.domain"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}