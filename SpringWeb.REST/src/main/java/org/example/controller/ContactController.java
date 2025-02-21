package org.example.controller;

import java.util.List;

import org.example.ContactRequest;
import org.example.Dto.ContactDto;
import org.example.facade.ContactFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactFacade contactFacade;

    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactRequest contactRequest) {
        return ResponseEntity.ok(contactFacade.createContact(contactRequest));
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDto> getContact(@PathVariable long contactId) {
        return ResponseEntity.ok(contactFacade.getContact(contactId));
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        return ResponseEntity.ok(contactFacade.getAllContacts());
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactDto> updateContact(
            @PathVariable long contactId,
            @RequestBody ContactRequest contactRequest) {
        return ResponseEntity.ok(contactFacade.updateContact(contactId, contactRequest));
    }
}
