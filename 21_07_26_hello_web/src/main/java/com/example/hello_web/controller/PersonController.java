package com.example.hello_web.controller;

import com.example.hello_web.dto.PersonDto;
import com.example.hello_web.entity.Person;
import com.example.hello_web.mapper.PersonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class PersonController {

    private final PersonMapper personMapper;

    private List<Person> persons = new ArrayList<>();

    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @ResponseBody
    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPersonById(@PathVariable(name = "id", required = true) int personId) {
        Person person = persons.stream()
                .filter(person1 -> person1.getId() == personId)
                .findFirst()
                .get();

        return personMapper.toPersonDto(person);
    }

    @ResponseBody
    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getPersons() {
        return persons
                .stream()
                .map(personMapper::toPersonDto)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPerson(@RequestBody PersonDto personDto) {
        Person personToAdd = personMapper.fromPersonDto(personDto);

        int id;
        if (persons.size() > 0) {
            int lastId = persons.get(persons.size() - 1).getId();
//            id = lastId + 1;
            id = ++lastId;
        } else {
            id = 1;
        }

        personToAdd.setId(id);

        persons.add(personToAdd);
    }

//    todo метод удаления (delete by id) и обновление по id (edit by id)
}
