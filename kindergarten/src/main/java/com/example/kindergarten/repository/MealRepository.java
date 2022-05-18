package com.example.kindergarten.repository;

import com.example.kindergarten.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MealRepository extends MongoRepository<Meal, String> {

    List<Meal> findAllByStudentId(String studentId);

}
