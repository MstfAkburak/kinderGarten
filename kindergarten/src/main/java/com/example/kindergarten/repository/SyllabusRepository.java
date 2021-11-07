package com.example.kindergarten.repository;

import com.example.kindergarten.model.Syllabus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepository extends MongoRepository<Syllabus, String> {
}
