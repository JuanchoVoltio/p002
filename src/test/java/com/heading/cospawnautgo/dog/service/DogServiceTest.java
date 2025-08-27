package com.heading.cospawnautgo.dog.service;

import com.heading.cospawnautgo.dog.model.Dog;
import com.heading.cospawnautgo.dog.repository.DogRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DogServiceTest {

    @Mock
    DogRepository repository;
    DogService testSubject;

    @BeforeAll
    void init(){
        testSubject = new DogService(repository);
    }

    @Test
    void givenADogWithNoId_whenUpdateDog_thenShouldReturnNull(){
        //GIVEN
        Dog dog = Dog.builder().id(null).build();

        //WHEN
        Dog result = testSubject.update(dog);

        //THEN
        assertNull(result);
    }

    @Test
    void givenADogWithNoName_whenUpdateDog_thenShouldReturnNull(){
        //GIVEN
        Dog dog = Dog.builder().id("dumy-id").name(null).build();

        //WHEN
        Dog result = testSubject.update(dog);

        //THEN
        assertNull(result);
    }

    @Test
    void givenADogWithNoOwner_whenUpdateDog_thenShouldReturnNull(){
        //GIVEN
        Dog dog = Dog.builder().id("dumy-id").name("dummy-name").owner(null).build();

        //WHEN
        Dog result = testSubject.update(dog);

        //THEN
        assertNull(result);
    }
}