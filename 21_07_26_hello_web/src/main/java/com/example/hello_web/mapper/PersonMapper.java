package com.example.hello_web.mapper;

import com.example.hello_web.dto.PersonDto;
import com.example.hello_web.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDto toPersonDto(Person person) {
        return new PersonDto(person.getFirstName(), person.getLastName(), person.getAge());
    }

    public Person fromPersonDto(PersonDto personDto) {
        return new Person(personDto.getFirstName(), personDto.getLastName(), personDto.getAge());
    }
}
