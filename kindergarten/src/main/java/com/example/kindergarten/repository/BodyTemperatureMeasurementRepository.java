package com.example.kindergarten.repository;

import com.example.kindergarten.model.BodyTemperatureMeasurement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyTemperatureMeasurementRepository extends MongoRepository<BodyTemperatureMeasurement,String> {

    List<BodyTemperatureMeasurement> findAllByStudentId(String studentId);
}
