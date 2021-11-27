package com.thoTsouDev.socialLoginOauth2.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class UserController {

    @GetMapping("/user")
    fun user(@AuthenticationPrincipal principal: OAuth2User): Map<String, Any?>? {

        //If you want to check the details that github shares with our app just -->
        //println(principal.attributes)

        return Collections.singletonMap("name", principal.getAttribute("name"))
    }
}