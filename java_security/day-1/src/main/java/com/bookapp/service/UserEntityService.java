package com.bookapp.service;

import com.bookapp.repo.UserEntity;

public interface UserEntityService {
    public UserEntity findByUsername(String username);
    public void addUserEntity(UserEntity userEntity);
}
