package com.davioooh.superrubrica.stats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserStatsController {
    private UserStatsService userStatsService;

    public UserStatsController(UserStatsService userStatsService) {
        this.userStatsService = userStatsService;
    }

    @GetMapping("/stats")
    ModelAndView statsPage() {
        return new ModelAndView("stats")
                .addObject("stats", userStatsService.getStats());
    }

}
