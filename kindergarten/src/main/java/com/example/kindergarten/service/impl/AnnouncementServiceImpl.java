package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Announcement;
import com.example.kindergarten.repository.AnnouncementRepository;
import com.example.kindergarten.service.AnnouncementService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public void saveAnnouncement(Announcement announcement) {
        try {
            if (Objects.nonNull(announcement)) {
                announcement.setDate(String.valueOf(new Date()));
                announcementRepository.save(announcement);
            }
        } catch (Exception e) {
            throw new NotFoundException("bir hata oluştu");
        }
    }

    @Override
    public void deleteAnnouncement(String id) {
        try {
            if (!StringUtils.isEmpty(id)) {
                Announcement announcement = announcementRepository.findById(id).get();
                if (Objects.nonNull(announcement)) {
                    announcementRepository.delete(announcement);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "' bulunamadı");
        }
    }

    @Override
    public void updateAnnouncement(String id, String description) {
        try {
            Announcement announcement = announcementRepository.findById(id).get();
            if (Objects.nonNull(announcement)) {
                announcement.setDate(String.valueOf(new Date()));
                announcement.setDescription(description);
                announcementRepository.save(announcement);
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip announcemen bulunamadı");
        }
    }

    @Override
    public List<Announcement> getAnnouncement() {
        return announcementRepository.findAll();
    }
}
