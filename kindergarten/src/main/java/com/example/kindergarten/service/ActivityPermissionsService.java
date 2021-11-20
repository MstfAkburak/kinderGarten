package com.example.kindergarten.service;

import com.example.kindergarten.model.ActivityPermissions;

import java.util.List;

public interface ActivityPermissionsService {

    void saveActivityPermission(ActivityPermissions activityPermissions);

    void deleteActivityPermission(String id);

    void updateActivityPermissions(String id, String studentId, Boolean isPermission, String date);

    List<ActivityPermissions> getActivityPermissions(String studentId);
}
