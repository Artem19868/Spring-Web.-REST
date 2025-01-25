package org.example.controller;

import org.example.facade.ContactFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactControllerContact {

    private final ContactFacade contactFacade;

    public ContactControllerContact(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @GetMapping("/{contactId}")
    public ContactDto getContactById(@PathVariable long contactId){
        return contactFacade.getAccount(contactId);
    }
}

