package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Lesson;
import com.example.kindergarten.model.Lessons;
import com.example.kindergarten.repository.LessonRepository;
import com.example.kindergarten.repository.LessonsRepository;
import com.example.kindergarten.service.LessonsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class LessonsServiceImpl implements LessonsService {

    private LessonsRepository lessonsRepository;
    private LessonRepository lessonRepository;

    public LessonsServiceImpl(LessonsRepository lessonsRepository, LessonRepository lessonRepository) {
        this.lessonsRepository = lessonsRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveLessons(Lessons lessons) {
        lessonsRepository.save(lessons);
    }

    @Override
    public void addLessons(String lessonsId, String lessonId) {
        Lessons lessons = lessonsRepository.findById(lessonsId).get();
        Lesson lesson = lessonRepository.findById(lessonId).get();
        if (Objects.nonNull(lessons) && Objects.nonNull(lesson)) {
            lessons.setLesson(setLessonList(lesson));
            lessonsRepository.save(lessons);
        } else {
            throw new NotFoundException(lesson.getName() + " isimli ders bulunamadı");
        }
    }

    public List<Lesson> setLessonList(Lesson lesson) {
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        return lessonList;
    }


}
