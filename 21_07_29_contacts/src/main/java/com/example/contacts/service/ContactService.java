package com.example.contacts.service;

import com.example.contacts.repo.IContractRepo;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private IContractRepo repo;

    public ContactService(IContractRepo repo) {
        this.repo = repo;
    }
}
