package org.example.facade;

import org.example.Contact;
import org.example.ContactDao;
import org.example.ContactRequest;
import org.example.controller.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactFacade {
    private final ContactDao contactDao;

    @Autowired
    public ContactFacade(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public ContactDto createAccount (ContactRequest contactRequest){
        var account = contactDao.addContact(contactRequest);
        return new ContactDto(account);
    }
    public ContactDto getAccount (long accountId){
        var account = contactDao.getContact(accountId);
        return new ContactDto(account);
    }
    public ContactDto[] getAllAccounts(){
        var contacts = contactDao.getAllContacts();
        List<ContactDto> contactDtos = new ArrayList<>();
        for (Contact contact : contacts){
            ContactDto contactDto = new ContactDto(contact);
            contactDtos.add(contactDto);
        }
        return contactDtos.toArray(new ContactDto[0]);
    }
    public ContactDto changeContact(long contactId, ContactRequest contactRequest){
        var contact = contactDao.changeContact(contactId,contactRequest);
        return new ContactDto(contact);
    }
}

