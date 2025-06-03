package com.heading.cospawnautgo.dog.service;

import com.heading.cospawnautgo.dog.model.Dog;
import com.heading.cospawnautgo.dog.repository.DogRepository;
import com.heading.cospawnautgo.global.service.BasicCrudService;
import org.apache.logging.log4j.util.Strings;
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

    /**
     * Creates a new record in the database for the new dog. The id of the dog is a combination of the owner's id and the dog's name.
     * @param entity
     * @return
     */
    @Override
    public Dog create(Dog entity) {
        entity.setId(entity.getOwner().getId().trim().toLowerCase() + entity.getName().trim().toLowerCase());
        entity.setRegisteredOn(LocalDateTime.now());
        return repository.save(entity);
    }

    /**
     * In case of not found an instance of
     * @param s
     * @return
     */
    @Override
    public Dog read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public List<Dog> readAll() {
        return repository.findAll();
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
