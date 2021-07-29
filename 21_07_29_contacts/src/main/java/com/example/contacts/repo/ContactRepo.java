package com.example.contacts.repo;

import com.example.contacts.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
//TODO дописать все методы
public class ContactRepo implements IContractRepo {

    private List<Contact> contacts = new ArrayList<>();

    @Override
    public void save(Contact contact) {
        contact.setId(generateId());
        contacts.add(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contacts;
    }

    @Override
    public Contact getById(int id) {
        return null;
    }

    @Override
    public void editById(int id) {

    }

    @Override
    public void deleteById(int id) {

    }

    private int generateId() {
        int id;
        if (contacts.size() > 0) {
            int lastId = contacts.get(contacts.size() - 1).getId();
            id = ++lastId;
        } else {
            id = 1;
        }
        return id;
    }
}
