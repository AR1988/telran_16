package com.telran.controller;

import com.telran.mapper.ContactMapper;
import com.telran.service.ContactService;
import org.springframework.web.bind.annotation.*;
import com.telran.dto.ContactToAddDto;
import com.telran.dto.ContactToDisplayDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {

    private final ContactService service;
    private final ContactMapper contactMapper;

    public ContactRestController(ContactService service, ContactMapper contactMapper) {
        this.service = service;
        this.contactMapper = contactMapper;
    }

    //url add:              POST        host/api/contacts
    //url edit:             PUT         host/api/contacts/{contactId}
    //url getAll:           GET         host/api/contacts
    //url getById:          GET         host/api/contacts/{contactId}
    //url deleteById:       DELETE      host/api/contacts/{contactId}
    //url searchByName:     GET         host/api/contacts/search?name=searchValue

    @PostMapping("")
    public void add(@RequestBody ContactToAddDto contactToAddDto) {
        service.addContact(contactToAddDto.firstName, contactToAddDto.lastName, contactToAddDto.age);
    }

    @PutMapping("/{id}")
    public void edit(@RequestBody ContactToAddDto contactToAddDto, @PathVariable(name = "id") int contactId) {
        service.editContact(contactToAddDto.firstName, contactToAddDto.lastName, contactToAddDto.age, contactId);
    }

    @GetMapping("")
    public List<ContactToDisplayDto> getAll() {
        return service.getAllContacts()
                .stream()
//                .map(contact -> contactMapper.toDto(contact))
                .map(contactMapper::toDto)
                .collect(Collectors.toList());
    }

//    @GetMapping("/{id}")
//    public ContactToDisplayDto getById(@PathVariable int id) {
//        return contactMapper.toDto(service.getById(id));
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

//    @GetMapping("/search")
//    public List<ContactToDisplayDto> searchByName(@RequestParam(name = "name") String searchTerm) {
//        return service.searchByName(searchTerm)
//                .stream()
//                .map(contactMapper::toDto)
//                .collect(Collectors.toList());
//    }
}
