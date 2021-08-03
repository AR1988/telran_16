package com.example.contacts.controller;

import com.example.contacts.mapper.ContactMapper;
import com.example.contacts.service.ContactService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {

    private final ContactService service;
    private final ContactMapper contactMapper;

    public ContactRestController(ContactService service, ContactMapper contactMapper) {
        this.service = service;
        this.contactMapper = contactMapper;
    }
}
