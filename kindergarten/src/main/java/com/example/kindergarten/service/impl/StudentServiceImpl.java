package com.example.kindergarten.service.impl;

import com.example.kindergarten.entity.request.FindStudentRequest;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.repository.UserRepository;
import com.example.kindergarten.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        }

    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student findByParent(List<String> parent) {
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
