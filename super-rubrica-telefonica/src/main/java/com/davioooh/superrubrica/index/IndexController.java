package com.davioooh.superrubrica.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class IndexController {
    @GetMapping("/")
    String indexPage() {
        return "redirect:/contacts";
    }
}
