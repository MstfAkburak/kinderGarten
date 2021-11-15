package com.example.kindergarten.repository;

import com.example.kindergarten.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealRepository extends MongoRepository<Meal, String> {

}
