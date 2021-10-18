package com.example.kindergarten.repository;

import com.example.kindergarten.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);

    User findByPhone(String phone);

    User findByEmail(String email);

}
