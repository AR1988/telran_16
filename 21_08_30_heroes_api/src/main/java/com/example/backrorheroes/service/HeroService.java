package com.example.backrorheroes.service;

import com.example.backrorheroes.entity.Hero;
import com.example.backrorheroes.exception.HeroNotFoundException;
import com.example.backrorheroes.repo.IHeroRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {
    private static final String HERO_NOT_FOUND = "HERO not found";
    private final IHeroRepo repo;

    public HeroService(IHeroRepo repo) {
        this.repo = repo;
    }

    public List<Hero> getAllHeroes() {
        return repo.findByOrderById();
    }

    public Hero getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new HeroNotFoundException(HERO_NOT_FOUND + " by id:" + id));
    }

    public Hero addHero(String name) {
        return repo.save(new Hero(name));
    }

    public void editHero(String name, int id) {
        Hero hero = repo.findById(id)
                .orElseThrow(() -> new HeroNotFoundException("can not edit this hero"));

        if (name != null)
            hero.setName(name);
        repo.save(hero);
    }

    public void deleteById(int id) {
        if (repo.existsById(id))
            repo.deleteById(id);
        else
            throw new HeroNotFoundException(HERO_NOT_FOUND);
    }

    public List<Hero> searchByName(String name) {
        return new ArrayList<>(repo.findHeroByNameContains(name));
    }


}
