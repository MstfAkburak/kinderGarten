package com.example.kindergarten.service;

import com.example.kindergarten.model.Dues;

import java.util.List;

public interface DuesService {

    void saveDues(Dues dues, String schoolNumber);

    List<Dues> getDues(String studentId);

    void updateDues(String duesId);

    void deleteDues(String id);
}
