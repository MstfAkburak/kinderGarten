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
    public List<Medicine> getMedicineList(@RequestParam String schoolNumber) {
        return medicineService.getStudentMedicine(schoolNumber);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveMedicine(@RequestBody Medicine medicine,
                                             @RequestParam String schoolNumber) {
        medicineService.saveMedicine(medicine, schoolNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteMedicine(@RequestParam String medicineId) {
        medicineService.deleteMedicine(medicineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateMedicine(@RequestParam String medicineId,
                                               @RequestParam Boolean isUsed) {
        medicineService.updateMedicine(medicineId, isUsed);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
