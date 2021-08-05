package com.example.contact_db.repo;

import com.example.contact_db.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IContractRepo extends CrudRepository<Contact, Integer> {

    List<Contact> findAll();

    List<Contact> findAllByFirstNameContainsIgnoreCase(String firstName);

    List<Contact> findAllByLastNameContains(String term);

    List<Contact> findAllByFirstName(String fistName);

    @Query("select c from Contact c where c.age > ?1")
    List<Contact> someSql(int age);

    List<Contact> findAllByAgeGreaterThan(int age);
}
