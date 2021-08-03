package com.example.contacts.service;

import com.example.contacts.entity.Contact;
import com.example.contacts.exeption.ContactNotFoundException;
import com.example.contacts.repo.IContractRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private static final String CONTACT_NOT_FOUND = "Contact not exist";
    private final IContractRepo repo;

    public ContactService(IContractRepo repo) {
        this.repo = repo;

        this.repo.add(new Contact("Vasja", "Pupkin", 18));
        this.repo.add(new Contact("Max", "Mustermann", 35));
        this.repo.add(new Contact("John", "Doe", 25));
        this.repo.add(new Contact("Mark", "Schmidt", 27));
        this.repo.add(new Contact("Anna", "Baumann", 26));
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

    public List<Contact> searchByName(String name) {
        return repo
                .getAll()
                .stream()
                .filter(contact -> contact.getFirstName().toLowerCase().contains(name.toLowerCase().trim()))
                .collect(Collectors.toList());
    }


    public void deleteById(int contactId) {
        Contact contact = repo.getById(contactId)
                .orElseThrow(() -> new ContactNotFoundException(CONTACT_NOT_FOUND));

        repo.delete(contact);
    }
}
