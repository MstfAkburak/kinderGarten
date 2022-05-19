package com.example.kindergarten.service;

import com.example.kindergarten.model.BodyIndex;

import java.util.List;

public interface BodyIndexService {

    void saveBodyIndex(BodyIndex bodyIndex, String schoolNumber);

    void deleteBodyIndex(String id);

    void updateBodyIndex(String id, BodyIndex bodyIndex);

    List<BodyIndex> getStudentBodyIndex(String schoolNumber);
}
