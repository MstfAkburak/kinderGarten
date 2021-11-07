package com.example.kindergarten.service;

import com.example.kindergarten.model.Medicine;

import java.util.List;

public interface MedicineService {

    void saveMedicine(Medicine medicine, String firstName, String lastName);

    void deleteMedicine(String medicineName, String firstName, String lastName);
    
    void updateMedicine(String id, Boolean isUsed, String description);

    List<Medicine> getStudentMedicine(String studentId);

}
