package com.thoTsouDev.socialLoginOauth2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.HttpStatusEntryPoint

@SpringBootApplication
class SocialLoginOauth2Application

fun main(args: Array<String>) {
	runApplication<SocialLoginOauth2Application>(*args)
}
