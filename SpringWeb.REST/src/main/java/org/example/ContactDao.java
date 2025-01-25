package org.example;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ContactDao {
    private Long contactId = 1L;
    private final Map<Long, Contact> contactIdMap;

    public ContactDao() {
        this.contactIdMap = new HashMap<>();
    }

    private Optional<Contact> findContact(long accountId){
        return Optional.ofNullable(contactIdMap.get(accountId));
    }

    public Contact addContact(ContactRequest contactRequest){
        Contact newContact = new Contact(contactId,contactRequest.getName(),contactRequest.getPhoneNumber(),contactRequest.getEmail());
        contactIdMap.put(contactId, newContact);
        contactId++;
        return newContact;
    }
    public Contact getContact(long id){
        return findContact(id).orElseThrow(() -> new IllegalArgumentException("Аккаунт с айди " + id + " не был найден"));
    }

    public Contact[] getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        for (long i = 1; i < contactId; i++){
            Contact contact = contactIdMap.get(i);
            if (contact != null) {
                contacts.add(contact);
            }
        }
        return contacts.toArray(new Contact[0]);
    }

    public Contact changeContact(long contactId, ContactRequest contactRequest){
        var contact = contactIdMap.get(contactId);
        contact.setName(contactRequest.getName());
        contact.setPhoneNumber(contactRequest.getPhoneNumber());
        contact.setEmail(contactRequest.getEmail());
        return contact;
    }
}

