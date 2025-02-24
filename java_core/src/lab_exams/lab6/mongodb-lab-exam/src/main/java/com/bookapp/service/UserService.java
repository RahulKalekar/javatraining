package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User updateUser(String id, User user);
    void deleteUser(String id);
    public List<JournalEntry> getJournalEntriesByUserId(String userId);
}
