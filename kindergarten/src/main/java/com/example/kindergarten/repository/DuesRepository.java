package com.example.kindergarten.repository;

import com.example.kindergarten.model.Dues;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuesRepository extends MongoRepository<Dues, String> {

    List<Dues> findAllByStudentIdOrderByDate(String studentId);
}
