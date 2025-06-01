package com.heading.cospawnautgo.dog.service;

import com.heading.cospawnautgo.dog.model.Dog;
import com.heading.cospawnautgo.dog.repository.DogRepository;
import com.heading.cospawnautgo.global.service.BasicCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DogService implements BasicCrudService<Dog, String> {

    protected DogRepository repository;

    @Autowired
    public DogService(DogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dog create(Dog entity) {
        entity.setId(entity.getOwner().getId() + entity.getName());
        entity.setRegisteredOn(LocalDateTime.now());
        return repository.save(entity);
    }

    @Override
    public Dog read(String s) {
        return null;
    }

    @Override
    public List<Dog> readAll() {
        return null;
    }

    @Override
    public Dog update(Dog entity) {
        return null;
    }

    @Override
    public boolean delete(Dog entity) {
        return false;
    }
}
