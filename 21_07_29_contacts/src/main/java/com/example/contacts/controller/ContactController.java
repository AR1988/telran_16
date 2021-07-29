package com.example.contacts.controller;

import com.example.contacts.dto.ContactToAddDto;
import com.example.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ContactController {

    private ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
//    @GetMapping("contacts")
    public String contacts() {
        //TODO передать List<ContactToDisplayDto>
        return "contacts";
    }

    @RequestMapping(value = "/contact-info/{id}", method = RequestMethod.GET)
    public String contactDetail(@PathVariable(name = "id") int contactId) {
        //TODO передать ContactToDisplayDto
        return "contact-details";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String contactForm() {

        return "contact-form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editContact(@PathVariable(name = "id") int contactId) {
        //TODO передать ContactToDisplayDto
        return "contact-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute ContactToAddDto contactToAddDto,
                              @RequestParam(name = "id", required = false) int contactId) {

        if (contactId > 0)
            //        TODO сохранить контакт в дб
            service.save(contactToAddDto);
        else
            //        TODO обновить контакт в дб
            service.edit(contactToAddDto, contactId);

        return "redirect:/contacts";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable(name = "id") int contactId) {
//        TODO удалить контакт в дб
        return "redirect:/contacts";
    }

}
