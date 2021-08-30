package com.example.backrorheroes.repo;

import com.example.backrorheroes.entity.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHeroRepo extends CrudRepository<Hero, Integer> {

    List<Hero> findAll();

    List<Hero> findHeroByNameContains(String name);

    List<Hero> findByOrderById();
}
