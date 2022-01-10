package com.example.kindergarten.controller;


import com.example.kindergarten.constants.RoleConstant;
import com.example.kindergarten.model.Lesson;
import com.example.kindergarten.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {


    private LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('" + RoleConstant.ROLE_ADMIN + "')")
    public List<Lesson> getLessonList() {
        return lessonService.getLessonList();
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveLesson(@RequestBody Lesson lesson) {
        return new ResponseEntity<>(lessonService.saveLesson(lesson), HttpStatus.OK);
    }

}

