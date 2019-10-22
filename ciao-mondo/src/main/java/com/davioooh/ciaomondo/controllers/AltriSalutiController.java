package com.davioooh.ciaomondo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/altri-saluti")
public class AltriSalutiController {

    @GetMapping
    public String unSalutoSemplice() {
        return "ciao-mondo";
    }

    @GetMapping("/verboso")
    public String unSalutoVerboso() {
        return "ciao-mondo-verboso";
    }

    @ModelAttribute("nome")
    public String nome() {
        return "David";
    }

}