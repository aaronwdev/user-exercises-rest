package com.williams.userexercisesrest.service;

import com.williams.userexercisesrest.entity.ExerciseEntity;
import com.williams.userexercisesrest.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public ExerciseEntity findExercise(int id) {
        ExerciseEntity exerciseEntity = exerciseRepository.findById(id);
        exerciseEntity.getId();
        return exerciseEntity;
    }

}
