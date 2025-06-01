package com.heading.cospawnautgo.dog.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
public class Dog {
    @Id
    String id;
    String name;
    Owner owner;
    Walker walker;
}
