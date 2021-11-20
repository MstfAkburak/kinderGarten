package com.example.kindergarten.repository;

import com.example.kindergarten.model.ActivityPermissions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityPermissionsRepository extends MongoRepository<ActivityPermissions, String> {

    List<ActivityPermissions> findAllByStudentId(String studentId);
}
