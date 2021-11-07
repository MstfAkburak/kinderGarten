package com.example.kindergarten.controller;

import com.example.kindergarten.model.Medicine;
import com.example.kindergarten.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/list")
    public List<Medicine> getMedicineList(@RequestParam String studentId) {
        return medicineService.getStudentMedicine(studentId);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveMedicine(@RequestBody Medicine medicine,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName) {
        medicineService.saveMedicine(medicine, firstName, lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteMedicine(@RequestParam String medicineName,
                                               @RequestParam String firstName,
                                               @RequestParam String lastName) {
        medicineService.deleteMedicine(medicineName, firstName, lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateMedicine(@RequestParam String id,
                                               @RequestBody Medicine medicine) {
        medicineService.updateMedicine(id, medicine.getIsUsed(), medicine.getDescription());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
