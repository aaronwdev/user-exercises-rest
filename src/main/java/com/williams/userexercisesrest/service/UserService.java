package com.williams.userexercisesrest.service;

import com.williams.userexercisesrest.entity.UserEntity;
import com.williams.userexercisesrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity findUser(int id) {
        UserEntity userEntity = userRepository.findById(id);
        userEntity.getId();
        return userEntity;
    }

}
