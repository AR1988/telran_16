package com.example.backrorheroes.controller;

import com.example.backrorheroes.dto.ErrorDto;
import com.example.backrorheroes.exception.HeroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(HeroNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDto handleHeroNotFoundException(HeroNotFoundException e) {
        return new ErrorDto(e.getMessage());
    }
}
