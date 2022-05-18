package com.example.kindergarten.controller;

import com.example.kindergarten.model.Dues;
import com.example.kindergarten.service.DuesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dues")
public class DuesController {

    private DuesService duesService;

    public DuesController(DuesService duesService) {
        this.duesService = duesService;
    }

    @GetMapping("/list")
    public List<Dues> getDues(@RequestParam String schoolNumber) {
        return duesService.getDues(schoolNumber);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveDues(@RequestBody Dues dues, @RequestParam String schoolNumber) {
        duesService.saveDues(dues, schoolNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteDues(@RequestParam String duesId) {
        duesService.deleteDues(duesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateDues(@RequestParam String duesId,
                                           @RequestBody Dues dues) {
        duesService.updateDues(duesId, dues.getValue(), dues.getDate(), dues.getPaymentDate());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
