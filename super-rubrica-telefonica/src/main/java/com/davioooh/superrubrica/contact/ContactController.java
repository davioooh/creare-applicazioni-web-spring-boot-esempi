package com.davioooh.superrubrica.contact;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacts")
class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/new")
    ModelAndView contactForm() {
        return new ModelAndView("contact-form")
                .addObject(new ContactForm());
    }

    @PostMapping("/new")
    ModelAndView handleNewContactSubmission(
            @Valid @ModelAttribute ContactForm contactForm,
            BindingResult bindingResult,
            RedirectAttributes attributes
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("contact-form");
        }

        Contact contact = contactService.saveContact(contactForm);
        attributes.addFlashAttribute("newContact", true);
        return new ModelAndView("redirect:/contacts?id=" + contact.getId());
    }

    @GetMapping
    ModelAndView contactDetails(@RequestParam("id") String contactId) {
        return contactService.getContact(contactId)
                .map(c -> new ModelAndView("contact-details")
                        .addObject("contact", c))
                .orElse(new ModelAndView("redirect:/", HttpStatus.NOT_FOUND));
    }

}
