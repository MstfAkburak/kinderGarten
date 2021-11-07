package com.example.kindergarten.controller;


import com.example.kindergarten.model.Lesson;
import com.example.kindergarten.model.Lessons;
import com.example.kindergarten.service.LessonService;
import com.example.kindergarten.service.LessonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {


    private LessonService lessonService;
    private LessonsService lessonsService;

    public LessonController(LessonService lessonService, LessonsService lessonsService) {
        this.lessonService = lessonService;
        this.lessonsService = lessonsService;
    }

    @GetMapping("/list")
    public List<Lesson> getLessonList() {
        return lessonService.getLessonList();
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveLesson(@RequestBody Lesson lesson) {
        lessonService.saveLesson(lesson);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveLessons")
    public ResponseEntity<Void> saveLessons(@RequestBody Lessons lessons) {
        lessonsService.saveLessons(lessons);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/addLesson")
    public ResponseEntity<Void> addLesson(@RequestParam String lessonsId,
                                          @RequestParam String lessonId) {
        lessonsService.addLessons(lessonsId, lessonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

