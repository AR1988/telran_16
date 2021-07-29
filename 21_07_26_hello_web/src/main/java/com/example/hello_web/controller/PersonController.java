package com.example.hello_web.controller;

import com.example.hello_web.dto.PersonDto;
import com.example.hello_web.entity.Person;
import com.example.hello_web.exeption.EntityNotFoundException;
import com.example.hello_web.mapper.PersonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonController {

    private static final String ENTITY_NOT_FOUND_MSG = "Entity not found";
    private final PersonMapper personMapper;

    private List<Person> persons = new ArrayList<>();

    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @GetMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPersonById(@PathVariable(name = "id", required = true) int personId) {
        Person person = persons.stream()
                .filter(person1 -> person1.getId() == personId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND_MSG));
        return personMapper.toPersonDto(person);
    }

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getPersons() {
        return persons
                .stream()
                .map(personMapper::toPersonDto)
                .collect(Collectors.toList());
    }

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

    @DeleteMapping("/person/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") long userId) {

        boolean isRemoved = persons.removeIf(person -> person.getId() == userId);
        if (!isRemoved) {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND_MSG);
        }
    }


    @PutMapping("/person/{id}")
    public void editById(@PathVariable(name = "id") long userId, @RequestBody PersonDto personDto) {
        Person personToEdit = persons.stream()
                .filter(person -> person.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND_MSG));

        if (personDto.getAge() > 0)
            personToEdit.setAge(personDto.getAge());

        if (personDto.getFirstName() != null)
            personToEdit.setFirstName(personDto.getFirstName());

        if (personDto.getLastName() != null)
            personToEdit.setLastName(personDto.getLastName());
    }
}
