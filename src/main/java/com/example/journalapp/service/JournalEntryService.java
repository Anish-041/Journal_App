package com.example.journalapp.service;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.entity.User;
import com.example.journalapp.repositry.JournalEntryRepositry;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepositry journalEntryRepositry;

    @Autowired
    private UserEntryService userEntryService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userEntryService.findByuserName(userName);
            JournalEntry saved = journalEntryRepositry.save(journalEntry);
            user.getJournalEntries().add(saved);
            userEntryService.saveUser(user);
        } catch (Exception e){
            log.error("Error",e);
            throw new RuntimeException("An error occurred while saving the journalEntry",e);
        }
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepositry.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepositry.findAll();
    }

    public Optional<JournalEntry> getOne(ObjectId id) {
        return journalEntryRepositry.findById(id);
    }

    @Transactional
    public boolean DeleteOne(ObjectId id , String userName) {
        boolean removed = false;
        try {
            User user = userEntryService.findByuserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userEntryService.saveUser(user);
                journalEntryRepositry.deleteById(id);
            }
        } catch (Exception e) {
            log.error("Error ",e);
            throw new RuntimeException("An error occurred while deleting the entry", e);
        }
        return removed;
    }

//    public List<JournalEntry> findByUserName(String userName) {
//
//    }
}

// Controller --> Service --> Repositry