package com.example.kindergarten.controller;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.BodyIndex;
import com.example.kindergarten.service.BodyIndexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/studentinformation")
public class StudentInformationController {

    private BodyIndexService bodyIndexService;

    public StudentInformationController(BodyIndexService bodyIndexService) {
        this.bodyIndexService = bodyIndexService;
    }

    @PostMapping("/save/bodyIndex")
    public ResponseEntity<Void> saveBodyIndex(@RequestBody BodyIndex bodyIndex) {
        bodyIndexService.saveBodyIndex(bodyIndex);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/bodyIndex")
    public ResponseEntity<Void> deleteBodyIndex(@RequestParam String id) {
        bodyIndexService.deleteBodyIndex(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/bodyIndex")
    public ResponseEntity<Void> updateBodyIndex(@RequestParam String id,
                                                @RequestBody BodyIndex bodyIndex) {
        bodyIndexService.updateBodyIndex(id, bodyIndex);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list/bodyIndex")
    public List<BodyIndex> getStudentBodyIndex(@RequestParam String studentId) {
        return bodyIndexService.getStudentBodyIndex(studentId);
    }
}
