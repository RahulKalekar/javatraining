package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryImplementation implements JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepository;

    @Autowired
    private UserRepo userRepo;

    @Override
    public JournalEntry createJournalEntry(String userId, JournalEntry entry) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        entry = journalEntryRepository.save(entry);
        user.getJournalEntries().add(entry);
        userRepo.save(user);
        return entry;
    }

    @Override
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    @Override
    public Optional<JournalEntry> getJournalEntryById(String id) {
        return journalEntryRepository.findById(id);
    }

    @Override
    public JournalEntry updateJournalEntry(String id, JournalEntry entry) {
        entry.setId(id);
        return journalEntryRepository.save(entry);
    }

    @Override
    public void deleteJournalEntry(String id) {
        journalEntryRepository.deleteById(id);
    }
}
