package com.example.kindergarten.controller;

import com.example.kindergarten.model.BodyIndex;
import com.example.kindergarten.service.BodyIndexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodyIndex")
public class BodyIndexController {

    private BodyIndexService bodyIndexService;

    public BodyIndexController(BodyIndexService bodyIndexService) {
        this.bodyIndexService = bodyIndexService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveBodyIndex(@RequestBody BodyIndex bodyIndex, @RequestParam String schoolNumber) {
        bodyIndexService.saveBodyIndex(bodyIndex, schoolNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteBodyIndex(@RequestParam String id) {
        bodyIndexService.deleteBodyIndex(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateBodyIndex(@RequestParam String id,
                                                @RequestBody BodyIndex bodyIndex) {
        bodyIndexService.updateBodyIndex(id, bodyIndex);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<BodyIndex> getStudentBodyIndex(@RequestParam String schoolNumber) {
        return bodyIndexService.getStudentBodyIndex(schoolNumber);
    }
}
