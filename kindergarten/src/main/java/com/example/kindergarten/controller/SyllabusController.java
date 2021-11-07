package com.example.kindergarten.controller;

import com.example.kindergarten.model.Syllabus;
import com.example.kindergarten.service.SyllabusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/syllabus")
public class SyllabusController {

    private SyllabusService syllabusService;

    public SyllabusController(SyllabusService syllabusService) {
        this.syllabusService = syllabusService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveLessons(@RequestBody Syllabus syllabus) {
        syllabusService.saveSyllabus(syllabus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addLesson(@RequestParam String syllabusId,
                                          @RequestParam String lessonId) {
        syllabusService.addSyllabus(syllabusId, lessonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

