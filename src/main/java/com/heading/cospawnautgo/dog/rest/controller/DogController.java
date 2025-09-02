package com.heading.cospawnautgo.dog.rest.controller;

import com.heading.cospawnautgo.dog.model.Dog;
import com.heading.cospawnautgo.dog.service.DogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@Tag(name = "Dog management", description = "APIs for managing dogs")
@RestController
@RequestMapping("v1/dog")//TODO: Read base path from properties
public class DogController {
    protected DogService dogService;
    @Autowired
    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @Operation(summary = "Retrieves all the registered dogs")
    @GetMapping//("/all")
    public ResponseEntity<Collection<Dog>> getAll(){
        Collection<Dog> result = dogService.readAll();
        return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(Collections.emptyList());
    }

    @Operation(summary = "Get all the information of one single dog.", description = "Find the information of the dog using the id, if not returns a null body.")
    @GetMapping("/{id}")
    public ResponseEntity<Dog> findById(@PathVariable String id){
        Dog result = dogService.read(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Operation(summary = "Creates a new dog if there's not created before.",
               description = "Saves the information of the dog in a new record if not exists. If not possible it will retrieve a not processable entity error.")
    @PostMapping//("/create")
    public ResponseEntity<Dog> create(@RequestBody Dog dog){
        Dog result = dogService.create(dog);
        return result != null ? ResponseEntity.status(HttpStatus.CREATED).body(result) : ResponseEntity.unprocessableEntity().body(dog);
    }
}
