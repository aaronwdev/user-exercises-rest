package com.williams.userexercisesrest.service;

import com.williams.userexercisesrest.UserExerciseLog;
import com.williams.userexercisesrest.entity.ExerciseEntity;
import com.williams.userexercisesrest.entity.UserEntity;
import com.williams.userexercisesrest.entity.UserExerciseLogEntity;
import com.williams.userexercisesrest.repository.ExerciseRepository;
import com.williams.userexercisesrest.repository.UserExerciseLogRepository;
import com.williams.userexercisesrest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserExerciseLogService {

    private UserExerciseLogRepository userExerciseLogRepository;
    private ExerciseRepository exerciseRepository;
    private UserRepository userRepository;
    private ExerciseEntity exerciseEntity;
    private UserEntity userEntity;

    UserExerciseLogService(UserExerciseLogRepository userExerciseLogRepository,
                           ExerciseRepository exerciseRepository,
                           UserRepository userRepository) {
        this.userExerciseLogRepository = userExerciseLogRepository;
        this.exerciseRepository = exerciseRepository;
        this.userRepository = userRepository;
    }

    public UserExerciseLog getLogEntryDetails(int id) {

        UserExerciseLog userExerciseLog = new UserExerciseLog();
        UserExerciseLogEntity logEntity = userExerciseLogRepository.findById(id);

        userExerciseLog.setLogId(logEntity.getId());
        userExerciseLog.setExerciseId(logEntity.getExerciseId());
        userExerciseLog.setDate(logEntity.getDate());
        userExerciseLog.setUserId(logEntity.getUserID());

        exerciseEntity = exerciseRepository.findById(logEntity.getExerciseId());
        userExerciseLog.setDescription(exerciseEntity.getDescription());

        userEntity = userRepository.findById(logEntity.getUserID());
        userExerciseLog.setUserName(userEntity.getName());

        return userExerciseLog;
    }

}
