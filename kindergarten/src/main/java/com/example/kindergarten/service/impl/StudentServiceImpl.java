package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.repository.UserRepository;
import com.example.kindergarten.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private UserRepository userRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveStudent(Student student) {
        if ((userRepository.findByUserName(student.getParent().stream().findAny().get())) != null) {
            studentRepository.save(student);
        } else {
            throw new NotFoundException(student.getParent().stream().findFirst().get() + " isimli veli bulunamadı.");
        }

    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student findByParent(String parent) {
        return studentRepository.findByParent(parent);
    }

    @Override
    public Student findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public Student findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
