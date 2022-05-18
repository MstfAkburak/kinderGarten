package com.example.kindergarten.service;

import com.example.kindergarten.model.Dues;

import java.util.List;

public interface DuesService {

    void saveDues(Dues dues, String schoolNumber);

    List<Dues> getDues(String studentId);

    void updateDues(String id, Double value, String date, String paymentDate );

    void deleteDues(String id);
}
