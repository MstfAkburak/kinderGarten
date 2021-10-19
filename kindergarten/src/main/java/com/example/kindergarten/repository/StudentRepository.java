package com.example.kindergarten.repository;

import com.example.kindergarten.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends MongoRepository<Student, String> {

    Student findByFirstName(String firstName);

    Student findByParent(List<String> parent);

    Student findByLastName(String lastName);

    Student findByFirstNameAndLastName(String firstName, String lastName);
}
