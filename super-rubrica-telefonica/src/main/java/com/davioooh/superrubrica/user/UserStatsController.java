package com.davioooh.superrubrica.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserStatsController {
    private UserService userService;

    public UserStatsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-stats")
    ModelAndView userInfoPage() {
        return new ModelAndView("user-stats")
                .addObject("stats", userService.getUserStats());
    }

}
