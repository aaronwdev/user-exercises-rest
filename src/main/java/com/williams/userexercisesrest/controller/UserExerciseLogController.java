package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.UserExerciseLog;
import com.williams.userexercisesrest.entity.UserExerciseLogEntity;
import com.williams.userexercisesrest.repository.UserExerciseLogRepository;
import com.williams.userexercisesrest.service.UserExerciseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping(path = "/log")
public class UserExerciseLogController {

    @Autowired
    UserExerciseLogService userExerciseLogService;

    @Autowired
    UserExerciseLogRepository userExerciseLogRepository;

    @RequestMapping(method = RequestMethod.GET)
    public UserExerciseLog getExerciseLog(@RequestParam(required = false) int id) {
        return userExerciseLogService.getLogEntryDetails(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserExerciseLogEntity postExercise(@RequestParam(required = false) int userid, int exerciseid, String date) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
        java.util.Date convertedDate = null;
        try {
            convertedDate = sdf1.parse(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlStartDate = new java.sql.Date(convertedDate.getTime());

        return userExerciseLogRepository.save(new UserExerciseLogEntity(userid, exerciseid, sqlStartDate));
    }

}
