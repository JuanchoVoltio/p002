package com.heading.cospawnautgo.dog.rest.controller;

import com.heading.cospawnautgo.dog.model.Dog;
import com.heading.cospawnautgo.dog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("{contextPath}/dog")
public class DogController {
    protected DogService dogService;

    @Autowired
    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<Collection<Dog>> getAll(){
        Collection<Dog> result = dogService.readAll();
        return result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(Collections.emptyList());
    }

    @PostMapping
    public ResponseEntity<Dog> create(@RequestBody Dog dog){
        Dog result = dogService.create(dog);
        return result != null ? ResponseEntity.status(HttpStatus.CREATED).body(result) : ResponseEntity.unprocessableEntity().body(dog);
    }
}
