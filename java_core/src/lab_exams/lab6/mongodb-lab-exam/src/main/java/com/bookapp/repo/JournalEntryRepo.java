package com.bookapp.repo;

import com.bookapp.entities.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalEntryRepo extends MongoRepository<JournalEntry, String> {
}
