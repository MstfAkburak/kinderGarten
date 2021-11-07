package com.example.kindergarten.repository;

import com.example.kindergarten.model.Lessons;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepository extends MongoRepository<Lessons, String> {
}
