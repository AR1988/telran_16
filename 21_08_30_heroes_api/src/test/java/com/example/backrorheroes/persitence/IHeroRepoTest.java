package com.example.backrorheroes.persitence;

import com.example.backrorheroes.entity.Hero;
import com.example.backrorheroes.repo.IHeroRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class IHeroRepoTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    IHeroRepo iHeroRepo;

    @Test
    public void add() {
        Hero hero = new Hero("hero name");

        entityManager.persist(hero);

        entityManager.flush();
        entityManager.clear();

        List<Hero> heroes = iHeroRepo.findAll();

        assertEquals(1, heroes.size());
        assertEquals(hero.getName(), heroes.get(0).getName());
    }

    @Test
    public void getAll() {
        Hero hero1 = new Hero("hero name1");
        Hero hero2 = new Hero("hero name2");
        Hero hero3 = new Hero("hero name3");

        entityManager.persist(hero1);
        entityManager.persist(hero2);
        entityManager.persist(hero3);

        entityManager.flush();
        entityManager.clear();

        List<Hero> heroes = iHeroRepo.findByOrderById();

        assertEquals(3, heroes.size());
    }

}
