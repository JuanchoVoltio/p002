package com.heading.cospawnautgo.dog.model;


import org.springframework.data.annotation.Id;

public class Dog {
    @Id
    String id;
    String name;
    Owner owner;
    Walker walker;
}
