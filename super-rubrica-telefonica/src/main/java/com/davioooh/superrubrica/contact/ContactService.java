package com.davioooh.superrubrica.contact;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
class ContactService {
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(ContactForm contactForm, String ownerUsername) {
        Contact c = mapContact(contactForm, ownerUsername);
        return contactRepository.save(c);
    }

    private Contact mapContact(ContactForm contactForm, String ownerUsername) {
        Contact c = new Contact();
        c.setFirstName(contactForm.getFirstName());
        c.setLastName(contactForm.getLastName());
        c.setPhone(contactForm.getPhone());
        c.setEmail(contactForm.getEmail());
        c.setOwnerUsername(ownerUsername);
        return c;
    }

    public Optional<Contact> getContact(long contactId, String ownerUsername) {
        return contactRepository.findByIdAndOwnerUsername(contactId, ownerUsername);
    }

    public Collection<Contact> getUserContacts(String ownerUsername) {
        return contactRepository.findByOwnerId(ownerUsername);
    }

}
