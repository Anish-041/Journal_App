package com.example.journalapp.repositry;

import com.example.journalapp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepositry extends MongoRepository<JournalEntry , ObjectId> {

}
