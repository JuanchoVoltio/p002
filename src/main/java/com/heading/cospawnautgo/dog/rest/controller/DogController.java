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
@RequestMapping("v1/dog")//TODO: Read base path from properties
public class DogController {
    protected DogService dogService;

    @Autowired
    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping//("/all")
    public ResponseEntity<Collection<Dog>> getAll(){
        Collection<Dog> result = dogService.readAll();
        return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(Collections.emptyList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> findById(@PathVariable String id){
        Dog result = dogService.read(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping//("/create")
    public ResponseEntity<Dog> create(@RequestBody Dog dog){
        Dog result = dogService.create(dog);
        return result != null ? ResponseEntity.status(HttpStatus.CREATED).body(result) : ResponseEntity.unprocessableEntity().body(dog);
    }
}
