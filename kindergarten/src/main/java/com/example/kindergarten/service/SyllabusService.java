package com.example.kindergarten.service;


import com.example.kindergarten.model.Syllabus;

public interface SyllabusService {
    void saveSyllabus(Syllabus syllabus);

    void addSyllabus(String syllabusId, String lessonId);

}
