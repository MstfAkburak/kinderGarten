package com.example.kindergarten.service;

import com.example.kindergarten.model.Meal;

import java.util.List;

public interface MealService {

    void saveMeal(Meal meal, String schoolNumber);

    List<Meal> getMeals(String schoolNumber);

    void updateMeal(String id, Meal meal);

}
