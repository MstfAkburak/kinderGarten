package com.example.kindergarten.repository;

import com.example.kindergarten.model.BodyIndex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyIndexRepository extends MongoRepository<BodyIndex, String> {

    List<BodyIndex> findAllByStudentId(String studentId);
}
