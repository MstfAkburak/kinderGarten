package com.example.kindergarten.repository;

import com.example.kindergarten.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine, String> {

    Medicine findByMedicineName(String medicineName);

    List<Medicine> findAllByStudentName(String studentName);

//    Medicine findById(String id);

}
