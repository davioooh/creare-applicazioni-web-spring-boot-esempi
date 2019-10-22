package com.davioooh.ciaomondo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class SalutiController {

    @RequestMapping(method = GET)
    public ModelAndView unSaluto() {
        return new ModelAndView("ciao-mondo")
                .addObject("nome", "David");
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