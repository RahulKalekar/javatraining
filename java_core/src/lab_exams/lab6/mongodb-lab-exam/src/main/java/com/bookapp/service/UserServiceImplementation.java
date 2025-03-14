package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepo userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public List<JournalEntry> getJournalEntriesByUserId(String userId) {
        return getUserById(userId).get().getJournalEntries();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
