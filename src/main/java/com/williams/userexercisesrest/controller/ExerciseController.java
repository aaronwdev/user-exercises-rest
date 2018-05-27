package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.entity.ExerciseEntity;
import com.williams.userexercisesrest.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/exercises")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ExerciseEntity createExercise(@RequestBody ExerciseEntity exerciseEntity) {
        return exerciseService.saveExercise(new ExerciseEntity(exerciseEntity.getDescription()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{exerciseId}")
    public ExerciseEntity returnExercise(@PathVariable Integer exerciseId) {
        return exerciseService.findExercise(exerciseId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ExerciseEntity> returnAllExercises() {
        return (List<ExerciseEntity>) exerciseService.findAllExercises();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{exerciseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExercise(@PathVariable int exerciseId) {
        exerciseService.deleteExercise(exerciseId);
    }


}