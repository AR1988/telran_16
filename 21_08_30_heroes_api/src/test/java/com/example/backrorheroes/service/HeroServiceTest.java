package com.example.backrorheroes.service;

import com.example.backrorheroes.entity.Hero;
import com.example.backrorheroes.exception.HeroNotFoundException;
import com.example.backrorheroes.repo.IHeroRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @InjectMocks
    HeroService heroService;
    @Mock
    IHeroRepo repo;

    @Test
    public void testGetAllHeroes() {
        heroService.getAllHeroes();
        verify(repo, times(1)).findByOrderById();
    }

    @Test
    public void getByIdTest_heroFound() {
        when(repo.findById(1)).thenReturn(Optional.of(new Hero("name")));

        heroService.getById(1);

        verify(repo, times(1)).findById(1);
    }

    @Test
    public void getByIdTest_heroNotFound() {
        Exception exception = assertThrows(HeroNotFoundException.class, () -> heroService.getById(898));

        assertNotNull(exception);
        assertEquals("HERO not found by id:898", exception.getMessage());
    }
}
