package org.example.controller;

import org.example.ContactRequest;
import org.example.facade.ContactFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactControllerContacts {

    private final ContactFacade contactFacade;

    public ContactControllerContacts(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @PostMapping
    public ContactDto createContact(@RequestBody ContactRequest contactRequest){
        return contactFacade.createAccount(contactRequest);
    }

    @GetMapping
    public ContactDto[] getAllContacts() {
        return contactFacade.getAllAccounts();
    }

    @PutMapping("/{contactId}")
    public ContactDto changeContact(@PathVariable long contactId, @RequestBody ContactRequest contactRequest) {
        return contactFacade.changeContact(contactId,contactRequest);
    }
}