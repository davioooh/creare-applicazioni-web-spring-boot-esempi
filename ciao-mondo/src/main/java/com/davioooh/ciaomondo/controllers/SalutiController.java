package com.davioooh.ciaomondo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class SalutiController {

    @RequestMapping(method = GET)
    public String unSaluto() {
        return "ciao-mondo";
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