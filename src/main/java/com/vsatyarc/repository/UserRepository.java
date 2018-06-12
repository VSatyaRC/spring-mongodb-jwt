package com.vsatyarc.repository;


import com.vsatyarc.model.security.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by VSatyaRC
 * E-Mail: v.satya.rc@gmail.com
 */

@Document
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User save(User user);
}
