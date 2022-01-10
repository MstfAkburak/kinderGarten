package com.example.kindergarten.service;


import com.example.kindergarten.model.Lesson;

import java.util.List;

public interface LessonService {
    boolean saveLesson(Lesson lesson);

    List<Lesson> getLessonList();

}
