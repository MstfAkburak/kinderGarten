package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.ActivityPermissions;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.ActivityPermissionsRepository;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.service.ActivityPermissionsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ActivityPermissionsServiceImpl implements ActivityPermissionsService {

    private ActivityPermissionsRepository activityPermissionsRepository;
    private StudentRepository studentRepository;

    public ActivityPermissionsServiceImpl(ActivityPermissionsRepository activityPermissionsRepository, StudentRepository studentRepository) {
        this.activityPermissionsRepository = activityPermissionsRepository;
        this.studentRepository = studentRepository;
    }

    public void saveActivityPermission(ActivityPermissions activityPermissions, String schoolNumber) {

        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);
            if (Objects.isNull(student)) {
                throw new NotFoundException(schoolNumber + " numaralı bir öğrenci bulunamadı");
            }
            String date = activityPermissions.getDate();
            activityPermissions.setStudentId(student.getId());
            activityPermissions.setDate(!StringUtils.isEmpty(date) ? date : String.valueOf(new Date()));
            activityPermissionsRepository.save(activityPermissions);
        } catch (Exception ex) {
            throw new NotFoundException("saveActivityPermission error : " + ex.getLocalizedMessage());
        }
    }

    public void deleteActivityPermission(String id) {
        try {
            if (!StringUtils.isEmpty(id)) {
                ActivityPermissions activityPermissions = activityPermissionsRepository.findById(id).get();
                if (Objects.nonNull(activityPermissions)) {
                    activityPermissionsRepository.delete(activityPermissions);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip bodyIndex bulunamadı");
        }
    }

    public void updateActivityPermissions(String id, String schoolNumber, Boolean isPermission, String date) {
        try {
            ActivityPermissions activityPermissions = activityPermissionsRepository.findById(id).get();
            Student student = studentRepository.findBySchoolNumber(schoolNumber);

            if (Objects.nonNull(activityPermissions) && Objects.nonNull(student)) {
                activityPermissions.setDate(!StringUtils.isEmpty(date) ? date : String.valueOf(new Date()));
                activityPermissions.setIsPermission(isPermission);
                activityPermissionsRepository.save(activityPermissions);
            }

        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip bodyIndex bulunamadı");
        }
    }

    public List<ActivityPermissions> getActivityPermissions(String schoolNumber) {
        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);

            if (Objects.isNull(student)) {
                throw new NotFoundException(schoolNumber + " numaralı öğrenci bulunamadı");
            }

            return activityPermissionsRepository.findAllByStudentId(student.getId());
        } catch (Exception ex) {
            throw new NotFoundException("getActivityPermission error : " + ex.getLocalizedMessage());
        }
    }


}
