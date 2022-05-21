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
    public void saveMedicine(Medicine medicine, String schoolNumber) {
        Student student = studentRepository.findBySchoolNumber(schoolNumber);
        if (Objects.nonNull(student)) {
            medicine.setStudentId(student.getId());
            medicine.setDate(new Date());
            medicine.setHour(String.valueOf(calendar.getTime()));
            medicine.setFirstName(student.getFirstName());
            medicine.setLastName(student.getLastName());
            medicineRepository.save(medicine);
        } else {
            throw new NotFoundException(student.getFirstName() + " " + student.getLastName() + " isimli öğrenci bulunamadı.");
        }
    }

    @Override
    public void deleteMedicine(String medicineId) {
        Medicine medicine = medicineRepository.findById(medicineId).get();
        if (Objects.nonNull(medicine)) {
            medicineRepository.delete(medicine);
        } else {
            throw new NotFoundException( medicineId + " isimli öğrenci bulunamadı.");
        }
    }


    @Override
    public void updateMedicine(String medicineId, Boolean isUsed) {
        Medicine changedMedicine = medicineRepository.findById(medicineId).get();

        if (Objects.isNull(changedMedicine)) {
            throw new NotFoundException("No activity found to update with this day = " + changedMedicine.getMedicineName());
        }

        changedMedicine.setDate(new Date());
        changedMedicine.setHour(String.valueOf(calendar.getTime()));
        changedMedicine.setIsUsed(isUsed);
        medicineRepository.save(changedMedicine);
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
