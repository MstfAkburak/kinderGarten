package com.example.kindergarten.controller;

import com.example.kindergarten.model.Meal;
import com.example.kindergarten.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveMeal(@RequestBody Meal meal, @RequestParam String schoolNumber) {
        mealService.saveMeal(meal, schoolNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Meal> getMeals(@RequestParam String schoolNumber) {
        return mealService.getMeals(schoolNumber);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateMeal(@RequestParam String id,
                                           @RequestBody Meal meal) {
        mealService.updateMeal(id, meal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
