package com.example.backrorheroes.mapper;

import com.example.backrorheroes.dto.HeroDto;
import com.example.backrorheroes.entity.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper {

    public Hero fromDto(HeroDto dto) {
        return new Hero(dto.name);
    }

    public HeroDto toDto(Hero hero) {
        return new HeroDto(hero.getName(), hero.getId());
    }
}
