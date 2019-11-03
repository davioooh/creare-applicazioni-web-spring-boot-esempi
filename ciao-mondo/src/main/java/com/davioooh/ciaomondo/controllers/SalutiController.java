package com.davioooh.ciaomondo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SalutiController {

    @GetMapping
    public ModelAndView unSaluto(
            @RequestParam("nome") String nome,
            @RequestHeader("User-Agent") String userAgent
    ) {
        return new ModelAndView("ciao-mondo")
                .addObject("nome", nome)
                .addObject("userAgent", userAgent);
    }

    @GetMapping("/{username}")
    public ModelAndView unSalutoConUrlPlaceholder(@PathVariable("username") String username) {
        return new ModelAndView("ciao-mondo-username")
                .addObject("username", username);
    }

    @GetMapping(params = "mio-parametro")
    public String unSalutoConParametro() {
        return "ciao-mondo-param";
    }

    @GetMapping(headers = "mio-header=test")
    public String unSalutoConHeader() {
        return "ciao-mondo-header";
    }

}