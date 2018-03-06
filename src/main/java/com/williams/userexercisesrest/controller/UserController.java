package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.entity.UserEntity;
import com.williams.userexercisesrest.repository.UserRepository;
import com.williams.userexercisesrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userRepository.save(new UserEntity(userEntity.getName(),
                userEntity.getPostcode()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public UserEntity returnUser(@PathVariable Integer userId) {
        return userService.findUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntity> returnAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestParam(required = false) int id) {
        userRepository.delete(id);
    }

}