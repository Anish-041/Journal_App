package com.example.journalapp.service;



import com.example.journalapp.entity.User;
import com.example.journalapp.repositry.UserEntryRepositry;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserEntryService {

    @Autowired
    private UserEntryRepositry userEntryRepositry;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger(UserEntryService.class);
/// Instead of using above method we added annotation @SLF4J

    public boolean saveNewUser(User userEntry) {
        try {
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRoles(Arrays.asList("USER"));
            userEntryRepositry.save(userEntry);
            return true;
        } catch (Exception e) {
            log.error("Error Occurred for {} :", userEntry.getUserName(), e);
            log.trace("!!!!Trace");
            log.debug("!!!!debug");
            log.info("!!Info");
            log.warn("!!!Warning");
            return false;
        }
    }

    public void saveAdmin(User userEntry) {
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRoles(Arrays.asList("USER","ADMIN"));
        userEntryRepositry.save(userEntry);
    }

    public void saveUser(User user) {
        userEntryRepositry.save(user);
    }


    public List<User> getAll() {
        return userEntryRepositry.findAll();
    }

    public Optional<User> getOne(ObjectId id) {
        return userEntryRepositry.findById(id);
    }

    public void DeleteOne(ObjectId id) {
        userEntryRepositry.deleteById(id);
    }

    public User findByuserName(String username) {
        return userEntryRepositry.findByuserName(username);
    }

    public void deleteByusername(String username) {
        userEntryRepositry.deleteByUserName(username);
    }


}
