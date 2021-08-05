package com.example.contact_db.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ContactToAddDto {

    @NotBlank(message = "{validation.firstname.default}")
    public String firstName;
    @NotBlank(message = "{validation.lastname.default}")
    public String lastName;
    @Min(0)
    @Max(100)
    public int age;

    public ContactToAddDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
