package com.example.journalapp.controller;

import com.example.journalapp.entity.User;
import com.example.journalapp.service.QuoteService;
import com.example.journalapp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    private UserEntryService userEntryService;

    @Autowired
    private QuoteService quoteService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User userEntry) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDB = userEntryService.findByuserName(userName);
         userInDB.setUserName(userEntry.getUserName());
         userInDB.setPassword(userEntry.getPassword());
         userEntryService.saveNewUser(userInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserBYId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userEntryService.deleteByusername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>("Hi " + authentication.getName() + "\nQuote for the Day is: "+ quoteService.getQuote().getHtmlFormat(),HttpStatus.OK);
    }
}
