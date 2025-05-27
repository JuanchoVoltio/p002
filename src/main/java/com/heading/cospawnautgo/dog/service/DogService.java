package com.heading.cospawnautgo.dog.service;

import com.heading.cospawnautgo.dog.model.Dog;
import com.heading.cospawnautgo.global.service.BasicCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService implements BasicCrudService<Dog, String> {
    @Override
    public Dog create(Dog entity) {
        return null;
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
