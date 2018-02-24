package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.entity.UserEntity;
import com.williams.userexercisesrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
/*
    @RequestMapping(method = RequestMethod.GET)
    public UserEntity returnUser(@RequestParam(required = false) int id) {
        return userRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestParam(required = false) String name) {
        userRepository.save(new UserEntity(name));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestParam(required = false) int id) {
        userRepository.delete(id);
    }

    */

}
