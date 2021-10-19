package com.example.kindergarten.controller;

import com.example.kindergarten.entity.request.FindStudentRequest;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @PostMapping("/find")
    @ResponseBody
    public Student findStudent(@RequestBody FindStudentRequest request){
        return  studentService.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
    }
}
