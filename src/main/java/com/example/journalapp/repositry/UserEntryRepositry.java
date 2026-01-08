package com.example.journalapp.repositry;


import com.example.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepositry extends MongoRepository<User, ObjectId > {
    User findByuserName(String username);
    void deleteByUserName(String username);
}
