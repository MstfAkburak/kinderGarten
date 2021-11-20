package com.example.kindergarten.controller;

import com.example.kindergarten.model.BodyTemperatureMeasurement;
import com.example.kindergarten.service.BodyTemperatureMeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodyTempature")
public class BodyTemperatureController {

    private BodyTemperatureMeasurementService bodyTemperatureMeasurementService;

    public BodyTemperatureController(BodyTemperatureMeasurementService bodyTemperatureMeasurementService) {
        this.bodyTemperatureMeasurementService = bodyTemperatureMeasurementService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveBodyTemperatureMeasurement(@RequestBody BodyTemperatureMeasurement bodyTemperatureMeasurement) {
        bodyTemperatureMeasurementService.saveBodyTemperatureMeasurement(bodyTemperatureMeasurement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteBodyTemperatureMeasurement(@RequestParam String id) {
        bodyTemperatureMeasurementService.deleteBodyTemperatureMeasurement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateBodyTemperatureMeasurement(@RequestParam String id,
                                                                 @RequestParam String studentId,
                                                                 @RequestParam Double bodyTemperature) {
        bodyTemperatureMeasurementService.updateBodyTemperatureMeasurement(id, studentId, bodyTemperature);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<BodyTemperatureMeasurement> getBodyTemperatureMeasurement(@RequestParam String studentId) {
        return bodyTemperatureMeasurementService.getBodyTemperatureMeasurement(studentId);
    }
}
