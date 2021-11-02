package com.example.kindergarten.controller;

import com.example.kindergarten.entity.request.FindStudentRequest;
import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/find")
    @ResponseBody
    public Student findStudent(@RequestBody FindStudentRequest request){
        return  studentService.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
    }

    @PostMapping("/find/firstName")
    @ResponseBody
    public Student findByFirstName(@RequestParam String firstName){
        return  studentService.findByFirstName(firstName);
    }

    @PostMapping("/find/parent")
    @ResponseBody
    public Student findByParent(@RequestParam String parent){
        return  studentService.findByParent(parent);
    }

}
