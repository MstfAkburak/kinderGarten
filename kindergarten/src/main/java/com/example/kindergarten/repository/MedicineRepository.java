package com.example.kindergarten.repository;

import com.example.kindergarten.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine, String> {

    Medicine findByMedicineName(String medicineName);

    List<Medicine> findAllByStudentId(String studentId);

}
