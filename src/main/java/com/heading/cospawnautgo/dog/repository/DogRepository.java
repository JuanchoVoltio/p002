package com.heading.cospawnautgo.dog.repository;

import com.heading.cospawnautgo.dog.model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends MongoRepository<Dog, String> {
}
