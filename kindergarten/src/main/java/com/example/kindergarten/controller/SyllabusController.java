package com.example.kindergarten.controller;

import com.example.kindergarten.model.Lessons;
import com.example.kindergarten.service.LessonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/syllabus")
public class SyllabusController {

    private LessonsService lessonsService;

    public SyllabusController(LessonsService lessonsService) {
        this.lessonsService = lessonsService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveLessons(@RequestBody Lessons lessons) {
        lessonsService.saveLessons(lessons);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

