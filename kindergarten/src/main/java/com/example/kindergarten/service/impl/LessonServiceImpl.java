package com.example.kindergarten.service.impl;

import com.example.kindergarten.model.Lesson;
import com.example.kindergarten.repository.LessonRepository;
import com.example.kindergarten.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> getLessonList() {
       return lessonRepository.findAll();
    }
}
