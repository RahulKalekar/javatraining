package com.bookapp.config;

import com.bookapp.repo.UserEntity;
import com.bookapp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyDetailService implements UserDetailsService {
    @Autowired
    private UserEntityService userEntityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityService.findByUsername(username);
        if(userEntity==null){
            throw new UsernameNotFoundException("User not found "+username);
        }
        // i need to convert userEntity to userDetails because spring security needs it
        return new SecUser(userEntity);
    }
}
