package com.example.hello_web.controller;

import com.example.hello_web.dto.PersonDto;
import com.example.hello_web.entity.Person;
import com.example.hello_web.mapper.PersonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api")
public class PersonController {

    private final PersonMapper personMapper;

    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @ResponseBody
    @GetMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPerson() {
        Person person = new Person("Max", "Mustermann", 30);
        return personMapper.toPersonDto(person);
    }

    @ResponseBody
    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getPersons() {
        Person person = new Person("Max", "Mustermann", 30);

        List<PersonDto> personList = Arrays.asList(
                personMapper.toPersonDto(person),
                personMapper.toPersonDto(person),
                personMapper.toPersonDto(person),
                personMapper.toPersonDto(person),
                personMapper.toPersonDto(person)
        );
        return personList;
    }
}
