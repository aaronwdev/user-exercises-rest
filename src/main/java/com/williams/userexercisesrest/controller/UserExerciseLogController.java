package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.UserExerciseLog;
import com.williams.userexercisesrest.entity.UserExerciseLogEntity;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{logId}")
    public UserExerciseLog returnExerciseLog(@PathVariable Integer logId) {
        return userExerciseLogService.getLogEntryDetails(logId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public UserExerciseLog saveExercise(@RequestBody UserExerciseLogEntity userExerciseLogEntity) {
        // TODO Assert the date is valid, if not show response
        return userExerciseLogService.getLogEntryDetails(userExerciseLogService
                .saveLogEntry(new UserExerciseLogEntity(userExerciseLogEntity.getUserId(),
                        userExerciseLogEntity.getExerciseId(),
                        userExerciseLogEntity.getDate())).getId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{logId}")
    public void delete(@PathVariable Integer logId) {
        userExerciseLogService.deleteLogEntry(logId);
    }
}
