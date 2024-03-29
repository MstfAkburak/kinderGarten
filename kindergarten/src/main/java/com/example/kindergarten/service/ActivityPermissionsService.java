package com.example.kindergarten.service;

import com.example.kindergarten.model.ActivityPermissions;

import java.util.List;

public interface ActivityPermissionsService {

    void saveActivityPermission(ActivityPermissions activityPermissions, String schoolNumber);

    void deleteActivityPermission(String id);

    void updateActivityPermissions(String id, Boolean isPermission);

    List<ActivityPermissions> getActivityPermissions(String schoolNumber);
}
