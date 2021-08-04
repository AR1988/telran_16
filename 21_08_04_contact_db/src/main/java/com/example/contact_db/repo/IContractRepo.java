package com.example.contact_db.repo;


import com.example.contact_db.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface IContractRepo {

    void add(Contact contact);

    List<Contact> getAll();

    Optional<Contact> getById(int id);

    void delete(Contact contact);

}
