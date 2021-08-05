package com.example.contact_db.controller;

import com.example.contact_db.dto.ErrorDto;
import com.example.contact_db.dto.FieldErrorDto;
import com.example.contact_db.exeption.ContactNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<FieldErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<FieldErrorDto> fieldErrorDtos = new ArrayList<>();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();

        for (ObjectError error : errors) {
            FieldErrorDto fieldErrorDto;
            if (error instanceof FieldError)
                fieldErrorDto = new FieldErrorDto(((FieldError) error).getField(), error.getDefaultMessage());
            else
                fieldErrorDto = new FieldErrorDto(error.getObjectName(), error.getDefaultMessage());
            fieldErrorDtos.add(fieldErrorDto);
        }

        return fieldErrorDtos;
    }

    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleContactNotFoundException(ContactNotFoundException e) {
        return new ErrorDto(e.getMessage());
    }
}
