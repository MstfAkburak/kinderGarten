package com.example.kindergarten.controller;

import com.example.kindergarten.model.Announcement;
import com.example.kindergarten.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveAnnouncement(@RequestBody Announcement announcement) {
        announcementService.saveAnnouncement(announcement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteAnnouncement(@RequestParam String id) {
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateAnnouncement(@RequestParam String id,
                                                   @RequestParam String description) {
        announcementService.updateAnnouncement(id, description);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Announcement> getAnnouncement() {
        return announcementService.getAnnouncement();
    }
}
