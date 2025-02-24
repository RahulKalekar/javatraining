package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import java.util.List;
import java.util.Optional;

public interface JournalEntryService {
    JournalEntry createJournalEntry(String userId, JournalEntry entry);
    List<JournalEntry> getAllJournalEntries();
    public Optional<JournalEntry> getJournalEntryById(String id);
    JournalEntry updateJournalEntry(String id, JournalEntry entry);
    void deleteJournalEntry(String id);
}
