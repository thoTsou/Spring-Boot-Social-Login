package com.thoTsouDev.socialLoginOauth2.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.csrfTokenRepository(
            CookieCsrfTokenRepository.withHttpOnlyFalse()
        )

        http?.authorizeRequests()
            ?.antMatchers("/", "/error", "/webjars/**")?.permitAll()
            ?.anyRequest()?.authenticated()

        http?.exceptionHandling()
            ?.authenticationEntryPoint(
                HttpStatusEntryPoint(
                    HttpStatus.UNAUTHORIZED
                )
            )
        http?.oauth2Login()

        http?.logout()
            ?.logoutSuccessUrl("/")?.permitAll()
    }
}