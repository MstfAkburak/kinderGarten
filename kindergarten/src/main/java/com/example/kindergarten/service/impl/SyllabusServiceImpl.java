package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Lesson;
import com.example.kindergarten.model.Syllabus;
import com.example.kindergarten.repository.LessonRepository;
import com.example.kindergarten.repository.SyllabusRepository;
import com.example.kindergarten.service.SyllabusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    private SyllabusRepository syllabusRepository;
    private LessonRepository lessonRepository;

    public SyllabusServiceImpl(SyllabusRepository syllabusRepository, LessonRepository lessonRepository) {
        this.syllabusRepository = syllabusRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveSyllabus(Syllabus syllabus) {
        syllabusRepository.save(syllabus);
    }

    @Override
    public void addSyllabus(String syllabusId, String lessonId) {
        Syllabus syllabus = syllabusRepository.findById(syllabusId).get();
        Lesson lesson = lessonRepository.findById(lessonId).get();
        if (Objects.nonNull(syllabus) && Objects.nonNull(lesson)) {
            syllabus.setLesson(setLessonList(lesson));
            syllabusRepository.save(syllabus);
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
