package com.davioooh.superrubrica.login;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    String loginPage(Authentication authentication) {
        if (authentication != null
                && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

}
