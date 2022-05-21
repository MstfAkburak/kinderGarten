package com.example.kindergarten.controller;

import com.example.kindergarten.model.ActivityPermissions;
import com.example.kindergarten.service.ActivityPermissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activityPermission")
public class ActivityPermissionsController {

    private ActivityPermissionsService activityPermissionsService;

    public ActivityPermissionsController(ActivityPermissionsService activityPermissionsService) {
        this.activityPermissionsService = activityPermissionsService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveActivityPermissions(@RequestBody ActivityPermissions activityPermissions, @RequestParam String schoolNumber) {
        activityPermissionsService.saveActivityPermission(activityPermissions, schoolNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteActivityPermissions(@RequestParam String id) {
        activityPermissionsService.deleteActivityPermission(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateActivityPermissions(@RequestParam String id,
                                                          @RequestParam Boolean isPermission) {
        activityPermissionsService.updateActivityPermissions(id, isPermission);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<ActivityPermissions> getActivityPermissions(@RequestParam String schoolNumber) {
        return activityPermissionsService.getActivityPermissions(schoolNumber);
    }
}
