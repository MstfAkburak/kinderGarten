package com.example.kindergarten.service;

import com.example.kindergarten.model.Meal;

import java.util.List;

public interface MealService {

    void saveMeal(Meal meal);

    List<Meal> getMeals(String studentId);

    void updateMeal(String id, Meal meal);

}
