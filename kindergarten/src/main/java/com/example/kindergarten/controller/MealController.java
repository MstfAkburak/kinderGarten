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

    @PostMapping("/add")
    public ResponseEntity<Void> saveMeal(@RequestBody Meal meal, @RequestParam String schoolNumber) {
        mealService.saveMeal(meal, schoolNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Meal> getMeals(@RequestParam String schoolNumber) {
        return mealService.getMeals(schoolNumber);
    }


    //meaal ID ve yenildi bilgisi olucak
    @PutMapping("/update")
    public ResponseEntity<Void> updateMeal(@RequestParam String mealId,
                                           @RequestParam Boolean isAttend) {
        mealService.updateMeal(mealId, isAttend);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
