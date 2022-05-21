package com.example.kindergarten.service;

import com.example.kindergarten.model.Medicine;

import java.util.List;

public interface MedicineService {

    void saveMedicine(Medicine medicine, String schoolNumber);

    void deleteMedicine(String medicineId);
    
    void updateMedicine(String medicineId, Boolean isUsed);

    List<Medicine> getStudentMedicine(String studentId);

}
