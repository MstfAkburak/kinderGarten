package com.example.kindergarten.service.impl;

import com.example.kindergarten.model.Lesson;
import com.example.kindergarten.repository.LessonRepository;
import com.example.kindergarten.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public boolean saveLesson(Lesson lesson) {
        return Objects.nonNull(lessonRepository.save(lesson));
    }

    @Override
    public List<Lesson> getLessonList() {
       return lessonRepository.findAll();
    }
}
