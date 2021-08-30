package com.example.backrorheroes.controller;

import com.example.backrorheroes.dto.HeroDto;
import com.example.backrorheroes.entity.Hero;
import com.example.backrorheroes.mapper.HeroMapper;
import com.example.backrorheroes.service.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/heroes")
public class HeroRestController {
    private final HeroService SERVICE;
    private final HeroMapper MAPPER;

    public HeroRestController(HeroService SERVICE, HeroMapper MAPPER) {
        this.SERVICE = SERVICE;
        this.MAPPER = MAPPER;
    }

    @PostMapping("")
    public HeroDto add(@RequestBody HeroDto heroDto) {
        Hero hero = SERVICE.addHero(heroDto.name);
        return MAPPER.toDto(hero);
    }

    @PutMapping("/{id}")
    public void edit(@RequestBody HeroDto toDto, @PathVariable(name = "id") int heroId) {
        SERVICE.editHero(toDto.name, heroId);
    }

    @GetMapping("")
    public List<HeroDto> getAll() {
        return SERVICE.getAllHeroes()
                .stream()
                .map(MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HeroDto getById(@PathVariable int id) {
        return MAPPER.toDto(SERVICE.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        SERVICE.deleteById(id);
    }
}
