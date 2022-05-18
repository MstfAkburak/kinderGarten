package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Medicine;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.MedicineRepository;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;
    private StudentRepository studentRepository;
    Calendar calendar = GregorianCalendar.getInstance();

    @Autowired
    public MedicineServiceImpl(MedicineRepository medicineRepository, StudentRepository studentRepository) {
        this.medicineRepository = medicineRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveMedicine(Medicine medicine, String firstName, String lastName) {
        Student student = studentRepository.findByFirstNameAndLastName(firstName, lastName);
        if (Objects.nonNull(student)) {
            medicine.setStudentId(student.getId());
            medicine.setDate(new Date());
            medicine.setHour(String.valueOf(calendar.getTime()));
            medicine.setFirstName(firstName);
            medicine.setLastName(lastName);
            medicineRepository.save(medicine);
        } else {
            throw new NotFoundException(firstName + " " + lastName + " isimli öğrenci bulunamadı.");
        }
    }

    @Override
    public void deleteMedicine(String medicineName, String firstName, String lastName) {
        Student student = studentRepository.findByFirstNameAndLastName(firstName, lastName);
        Medicine medicine = medicineRepository.findByMedicineName(medicineName);
        if (Objects.nonNull(student) && Objects.nonNull(medicine)) {
            medicineRepository.delete(medicine);
        } else {
            throw new NotFoundException(firstName + " " + lastName + " isimli öğrenci bulunamadı.");
        }
    }


    @Override
    public void updateMedicine(String medicineName, Boolean isUsed, String description) {
        Medicine medicine = medicineRepository.findByMedicineName(medicineName);

        if (Objects.isNull(medicine)) {
            throw new NotFoundException("No activity found to update with this day = " + medicine.getMedicineName());
        }

        medicine.setFirstName(medicine.getFirstName());
        medicine.setLastName(medicine.getLastName());
        medicine.setDate(new Date());
        medicine.setHour(String.valueOf(calendar.getTime()));
        medicine.setIsUsed(isUsed);
        medicine.setDescription(description);
         medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getStudentMedicine(String schoolNumber) {
        Student student = studentRepository.findBySchoolNumber(schoolNumber);
        if(Objects.isNull(student)) {
            throw new NotFoundException("No found student with number " + schoolNumber);
        }
        return  medicineRepository.findAllByStudentId(student.getId());
    }
}
