package com.example.kindergarten.service;

import com.example.kindergarten.model.Announcement;

import java.util.List;

public interface AnnouncementService {

    void saveAnnouncement(Announcement announcement);

    void deleteAnnouncement(String id);

    void updateAnnouncement(String id, String description);

    List<Announcement> getAnnouncement();
}
