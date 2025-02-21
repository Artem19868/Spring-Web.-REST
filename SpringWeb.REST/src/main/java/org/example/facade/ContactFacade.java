package org.example.facade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.example.ContactDao;
import org.example.ContactRequest;
import org.example.Dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactFacade {
    private final ContactDao contactDao;

    @Autowired
    public ContactFacade(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public ContactDto createContact (ContactRequest contactRequest){
        var contact = contactDao.addContact(contactRequest);
        return new ContactDto(contact);
    }
    public ContactDto getContact (long contactId){
        var contact = contactDao.getContact(contactId);
        return new ContactDto(contact);
    }
    public List<ContactDto> getAllContacts() {
    return Arrays.stream(contactDao.getAllContacts())
            .map(ContactDto::new)
            .collect(Collectors.toList());
}
    public ContactDto updateContact(long contactId, ContactRequest contactRequest){
        var contact = contactDao.changeContact(contactId,contactRequest);
        return new ContactDto(contact);
    }
}

