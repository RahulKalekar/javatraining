package com.bookapp.controller;

import com.bookapp.entities.JournalEntry;
import com.bookapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journalEntry")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping("/create/{userId}")
    public JournalEntry createJournalEntry(@PathVariable String userId, @RequestBody JournalEntry entry) {
        return journalEntryService.createJournalEntry(userId, entry);
    }

    @GetMapping("/all")
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryService.getAllJournalEntries();
    }

    @PutMapping("/{id}")
    public JournalEntry updateJournalEntry(@PathVariable String id, @RequestBody JournalEntry entry) {
        return journalEntryService.updateJournalEntry(id, entry);
    }

    @DeleteMapping("/{id}")
    public void deleteJournalEntry(@PathVariable String id) {
        journalEntryService.deleteJournalEntry(id);
    }

}
