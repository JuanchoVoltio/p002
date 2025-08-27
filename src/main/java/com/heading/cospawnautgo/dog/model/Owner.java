package com.heading.cospawnautgo.dog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Builder
@Getter
@Setter
public class Owner {
    @Id
    String id;
    String name;
    List<Dog> dogs;
}
