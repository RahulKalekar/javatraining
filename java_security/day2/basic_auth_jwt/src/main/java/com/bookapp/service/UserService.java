package com.bookapp.service;

import com.bookapp.entities.UserEntity;

public interface UserService {
    public UserEntity findByUsername(String username);
    public void addUserEntity(UserEntity userEntity);
}