package com.example.contacts.service;

import com.example.contacts.entity.Contact;
import com.example.contacts.exeption.ContactNotFoundException;
import com.example.contacts.repo.IContractRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private static final String CONTACT_NOT_FOUND = "Contact not exist";
    private final IContractRepo repo;

    public ContactService(IContractRepo repo) {
        this.repo = repo;
    }

    public List<Contact> getAllContacts() {
        return repo.getAll();
    }

    public Contact getById(int contactId) {
        return repo.getById(contactId)
                .orElseThrow(() -> new ContactNotFoundException(CONTACT_NOT_FOUND));
    }

    public void addContact(String firstName, String lastName, int age) {
        Contact contact = new Contact(firstName, lastName, age);
        repo.add(contact);
    }

    public void editContact(String firstName, String lastName, int age, int contactId) {
        Contact contact = repo.getById(contactId)
                .orElseThrow(() -> new ContactNotFoundException(CONTACT_NOT_FOUND));

        if (firstName != null)
            contact.setFirstName(firstName);
        if (lastName != null)
            contact.setLastName(lastName);
        if (age > 0)
            contact.setAge(age);
    }

//    TODO дописать
    public List<Contact> searchByName(String name) {
        return
    }


    public void deleteById(int contactId) {
        Contact contact = repo.getById(contactId)
                .orElseThrow(() -> new ContactNotFoundException(CONTACT_NOT_FOUND));

        repo.delete(contact);
    }
}
