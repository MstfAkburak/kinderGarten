package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Meal;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.MealRepository;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.service.MealService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;
    private StudentRepository studentRepository;

    public MealServiceImpl(MealRepository mealRepository, StudentRepository studentRepository) {
        this.mealRepository = mealRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void saveMeal(Meal meal, String schoolNumber) {
        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);
            meal.setStudentId(student.getId());
            if (StringUtils.isEmpty(meal.getDate())) {
                meal.setDate(String.valueOf(new Date()));
            }
            mealRepository.save(meal);
        } catch (Exception ex) {
            throw new NotFoundException("Meal Save error : " + ex.getLocalizedMessage());
        }
    }

    @Override
    public List<Meal> getMeals(String schoolNumber) {
        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);
            if (Objects.isNull(student)) {
                throw new NotFoundException(student.getSchoolNumber() + " numaralı  öğrenci bulunamadı");
            }
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(new Date());
            System.out.println(date);
            return
            mealRepository.findAllByStudentId(student.getId()).
                    stream().
                    filter(meal -> meal.getDate().equals(date)).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new NotFoundException("getMeals error : " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void updateMeal(String mealId, Boolean isAttend) {

        try {
            Meal searchMeal = mealRepository.findById(mealId).get();

            if (Objects.isNull(searchMeal)) {
                throw new NotFoundException("bulunamadı");
            }

            searchMeal.setDate(String.valueOf(new Date()));
            searchMeal.setIsAttend(isAttend);
            mealRepository.save(searchMeal);
        } catch (Exception ex) {
            throw new NotFoundException("updateMeal error : " + ex.getLocalizedMessage());
        }
    }

}
