package com.example.kindergarten.service;

import com.example.kindergarten.model.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student findByFirstName(String firstName);

    Student findByParent(String parent);

    Student findByLastName(String lastName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

}
