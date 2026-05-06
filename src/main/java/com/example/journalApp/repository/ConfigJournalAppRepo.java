package com.example.journalApp.repository;

import com.example.journalApp.entity.ConfigJournalApp;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepo extends MongoRepository<ConfigJournalApp, ObjectId> {

}
