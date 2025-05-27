package com.heading.cospawnautgo.dog.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Owner {
    @Id
    String id;
    String name;
    List<Dog> dogs;
}
