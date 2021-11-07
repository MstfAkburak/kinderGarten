package com.example.kindergarten.service;


import com.example.kindergarten.model.Lessons;

public interface LessonsService {
    void saveLessons(Lessons lessons);

    void addLessons(String lessonsId, String lessonId);

}
