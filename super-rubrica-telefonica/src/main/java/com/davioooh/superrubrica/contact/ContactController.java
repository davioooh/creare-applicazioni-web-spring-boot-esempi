package com.davioooh.superrubrica.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
class ContactController {

    @GetMapping("/new")
    ModelAndView contactForm() {
        return new ModelAndView("contact-form")
                .addObject(new ContactForm());
    }

    @PostMapping("/new")
    ModelAndView handleNewContactSubmission(@ModelAttribute ContactForm contactForm) {
        return new ModelAndView("contact-details")
                .addObject("contact", contactForm);
    }

}