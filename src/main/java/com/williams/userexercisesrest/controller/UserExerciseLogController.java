package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.UserExerciseLog;
import com.williams.userexercisesrest.entity.UserExerciseLogEntity;
import com.williams.userexercisesrest.repository.UserExerciseLogRepository;
import com.williams.userexercisesrest.service.UserExerciseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/log")
public class UserExerciseLogController {

    @Autowired
    UserExerciseLogService userExerciseLogService;

    @Autowired
    UserExerciseLogRepository userExerciseLogRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{logId}")
    public UserExerciseLog getExerciseLog(@PathVariable Integer logId) {
        return userExerciseLogService.getLogEntryDetails(logId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public UserExerciseLog saveExercise(@RequestBody UserExerciseLogEntity userExerciseLogEntity) {
        // TODO Assert the date is valid, if not show response
        return userExerciseLogService.getLogEntryDetails(userExerciseLogRepository
                .save(new UserExerciseLogEntity(userExerciseLogEntity.getUserID(),
                        userExerciseLogEntity.getExerciseId(),
                        userExerciseLogEntity.getDate())).getId());
    }

}
