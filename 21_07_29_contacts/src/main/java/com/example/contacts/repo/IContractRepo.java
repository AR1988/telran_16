package com.example.contacts.repo;

import com.example.contacts.entity.Contact;

import java.util.List;

public interface IContractRepo {

    void save(Contact contact);

    List<Contact> getAll();

    Contact getById(int id);

    void editById(int id);

    void deleteById(int id);


}
